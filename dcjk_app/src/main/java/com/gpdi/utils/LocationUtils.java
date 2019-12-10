package com.gpdi.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import java.awt.geom.Point2D;
import java.util.Map;

/**
 * @Auther: Kevin Cui
 * @Date: 18/6/26 14:57
 * @Description:地图计算相关处理
 */
public class LocationUtils {
    /**
     * 地球赤道半径(km)
     */
    private final static double EARTH_RADIUS = 6378.137;
    /**
     * 地球每度的弧长(km)
     */
    public final static double EARTH_ARC = 111.199;

    /**
     * 根据一个点计算固定范围内的经纬度范围
     *
     * @param longitude
     * @param latitude
     * @param distance
     * @return
     */
    public static Map<String, Double> calculationGeographicScope(double longitude, double latitude, double distance) {
        //先计算查询点的经纬度范围
        distance = distance / 1000;//0.5千米距离
        double dlng = 2 * Math.asin(Math.sin(distance / (2 * EARTH_RADIUS)) / Math.cos(latitude * Math.PI / 180));
        dlng = dlng * 180 / Math.PI;//角度转为弧度
        double dlat = distance / EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;
        Map<String, Double> result = new HashedMap();
        result.put("minlat", minlat);
        result.put("maxlat", maxlat);
        result.put("minlng", minlng);
        result.put("maxlng", maxlng);
        return result;
    }


    /**
     * 转化为弧度(rad)
     *
     * @auther: Kevin Cui
     * @date: 2018/7/25 17:03
     */
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }

    /**
     * 方位角（有误）
     *
     * @auther: Kevin Cui
     * @date: 2018/7/26 10:27
     */
    public static double getBearing(double lat_a, double lng_a, double lat_b, double lng_b) {

        double y = Math.sin(lng_b - lng_a) * Math.cos(lat_b);
        double x = Math.cos(lat_a) * Math.sin(lat_b) - Math.sin(lat_a) * Math.cos(lat_b) * Math.cos(lng_b - lng_a);
        double brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        if (brng < 0)
            brng = brng + 360;
        return brng;

    }


    public static double azimuthAngle(double x1, double y1, double x2, double y2) {
        double dx, dy, angle = 0;
        dx = x2 - x1;
        dy = y2 - y1;
        if (x2 == x1) {
            angle = Math.PI / 2.0;
            if (y2 == y1) {
                angle = 0.0;
            } else if (y2 < y1) {
                angle = 3.0 * Math.PI / 2.0;
            }
        } else if ((x2 > x1) && (y2 > y1)) {
            angle = Math.atan(dx / dy);
        } else if ((x2 > x1) && (y2 < y1)) {
            angle = Math.PI / 2 + Math.atan(-dy / dx);
        } else if ((x2 < x1) && (y2 < y1)) {
            angle = Math.PI + Math.atan(dx / dy);
        } else if ((x2 < x1) && (y2 > y1)) {
            angle = 3.0 * Math.PI / 2.0 + Math.atan(dy / -dx);
        }
        return (angle * 180 / Math.PI);
    }

    /**
     * 方位角，角度（单位：°）
     *
     * @auther: Kevin Cui
     * @date: 2018/7/25 17:05
     */
    public static double getAzimuth(double lon1, double lat1, double lon2, double lat2) {
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        lon1 = rad(lon1);
        lon2 = rad(lon2);
        double azimuth = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1);
        azimuth = Math.sqrt(1 - azimuth * azimuth);
        azimuth = Math.cos(lat2) * Math.sin(lon2 - lon1) / azimuth;
        azimuth = Math.asin(azimuth) * 180 / Math.PI;
        if (Double.isNaN(azimuth)) {
            if (lon1 < lon2) {
                azimuth = 90.0;
            } else {
                azimuth = 270.0;
            }
        }
        return azimuth;
    }

    /**
     * 已知一点经纬度A，和与另一点B的距离和方位角，求B的经纬度
     *
     * @auther: Kevin Cui
     * @date: 2018/7/26 10:32
     */
    public static String convertDistanceToLogLat(double lng1, double lat1, double distance, double azimuth) {
        distance = distance / 1000;
        azimuth = rad(azimuth);
        // 将距离转换成经度的计算公式
        double lon = lng1 + (distance * Math.sin(azimuth)) / (EARTH_ARC * Math.cos(rad(lat1)));
        // 将距离转换成纬度的计算公式
        double lat = lat1 + (distance * Math.cos(azimuth)) / EARTH_ARC;
        return lon + "," + lat;
    }

    /*
     * 计算一个点是否在扇形范围
     * @param pointLng  点经度
     * @param pointLat  点维度
     * @param centerLng 扇形圆心经度
     * @param cneterLat 扇形圆心维度
     * @param redius    扇形半径
     * @param centerAzimuth 扇形中轴线角度
     * @param totalAzimuth  扇形总角度
     *
     * @auther: Wuxf
     * @date: 2018/8/9 20:52
     * */
    public static boolean isContainInSector(double pointLng, double pointLat, double centerLng, double centerLat, double redius, double centerAzimuth, double totalAzimuth) {
        //计算两点距离，如果大于扇形半径，则不是范围内
        double distance = getDistance(pointLat, pointLng, centerLat, centerLng);
        if (distance > redius) {
            return false;
        }
        //计算两点角度是否在扇形范围
        double pointToCenterAzimuth = getAzimuth(pointLng, pointLat, centerLng, centerLat);
        boolean isContain = isContainInAngleScope(calcSimpleAzimuth(centerAzimuth, -(totalAzimuth / 2)), calcSimpleAzimuth(centerAzimuth, totalAzimuth / 2), calcSimpleAzimuth(pointToCenterAzimuth, 0D));
        if (isContain) {
            return true;
        }
        return false;
    }

    /*
     * 求两个角度的差的绝对值
     * @param 原度数
     * @param 加减因子
     *
     * @auther: Wuxf
     * @date: 2018/8/10 8:50
     * */
    public static double calcSimpleAzimuth(double origion, double summand) {
        double result = (origion % 360D) + (summand % 360D);
        result = result % 360D;
        if (result < 0) {
            result = result + 360D;
        }
        return result;
    }

    /**
     * @param angle
     * @return double
     * @description 求角度在0~360度中的实际角度
     **/
    public static double getAbsoluteAngle(double angle) {
        double result = angle % 360D;
        if (result < 0) {
            result = result + 360D;
        }
        return result;
    }

    /*
     * 判断一个角度是否在一个角度范围（360度）
     * @param scope1  左侧角度
     * @param scope2  右侧角度
     * @param angle 待判断角度
     * @auther: Wuxf
     * @date: 2018/8/10 8:56
     * */
    public static boolean isContainInAngleScope(double scope1, double scope2, double angle) {
        if (angle >= scope1 && angle <= scope2) {
            return true;
        } else if (scope1 > 180 && scope2 < 180) {
            if (angle > scope1) {
                return true;
            } else if (angle < scope2) {
                return true;
            }
        }
        return false;
    }

    /*
     * 计算扇形覆盖某点最优夹角
     * @param azimuth 扇形中轴线y轴正方向的夹角
     * @param sectorAngle 扇形夹角
     * @param pointAngle 扇形圆心和待覆盖点的连线与y轴正方向的夹角
     * @auther: Wuxf
     * */
    public static double calcSectorOptimalAzimuth(double azimuth, double sectorAngle, double pointToAngle) {
        double positiveAzimuth = calcSimpleAzimuth(azimuth, 0D); //转为正数角度
        //扇形两边与y轴的夹角
        double rightAngle = azimuth + sectorAngle / 2;
        double leftAngle = azimuth - sectorAngle / 2;
        double rightMinAngle = calcMinAngleBetweenTowAngle(rightAngle, pointToAngle);//右边最少调整角度
        double leftMinAngle = calcMinAngleBetweenTowAngle(leftAngle, pointToAngle);//左边最少调整角度
        return Math.abs(rightMinAngle) <= Math.abs(leftMinAngle) ? rightMinAngle : leftMinAngle;
    }

    /*
     * 求角度A与角度B重合，角度A调整的最少角度数
     * @auther: Wuxf
     * */
    public static double calcMinAngleBetweenTowAngle(double angleA, double angleB) {
        angleA = calcSimpleAzimuth(angleA, 0D);
        angleB = calcSimpleAzimuth(angleB, 0D);
        double diffValue = angleB - angleA;
        double value = diffValue;
        if (Math.abs(diffValue) > 180) {  //求最小调整角度
            if (diffValue >= 0) {
                diffValue = -(360 - diffValue);
            } else {
                diffValue = 360 + diffValue;
            }
        }
        return diffValue;
    }
    /*
     * 获取扇形内的多个点
     * 方法:在扇形内模拟多条半径，在半径上隔一定距离设一个点
     * 点的总数=radiusNum * perDistance
     * @param sector
     * @param sectorPieces 扇形切割份数
     * @param radiusPieces 半径切割间隔距离
     *
     * */
//    public static List<PointOfSector> getPointsOfSector(Sector sector,int sectorPieces,int radiusPieces){
//        List<PointOfSector> result = new ArrayList<>();
//        double perAngle = sector.getAngle()/sectorPieces; //每条半径增加角度
//        double perDistance = sector.getRadius()/radiusPieces;//点在半径上递进量
//        double initialAzimuth = sector.getAzimuth()-sector.getAngle()/2; //初始方位角--取扇形左侧边的角度
//        double initialDistance = 0D;//距离圆心的距离
//        //计算出扇形中的点
//        for(int i=0;i<=sectorPieces;i++){
//            double currentAzimuth = initialAzimuth + perAngle*i; //当前方位角
//            for(int j=0;j<=radiusPieces;j++){
//                double currentDistance = initialDistance + perDistance*j;//距离圆心的距离
//                String locationStr = convertDistanceToLogLat(sector.getLongtitude(),sector.getLatitude(),currentDistance,currentAzimuth);
//                String[] locationArray=locationStr.split(",");
//                double lng = Double.parseDouble(locationArray[0]);
//                double lat = Double.parseDouble(locationArray[1]);
//                PointOfSector point = new PointOfSector();
//                point.setLongtitude(lng);
//                point.setLatitude(lat);
//                point.setDistance(currentDistance);
//                point.setAzimuth(currentAzimuth);
//                result.add(point);
//            }
//        }
//        return result;
//    }

    /*
     * 求在点A的n米范围内的点
     * @param longtitude A点经度
     * @param latitude   A点维度
     * @parma JSONArray  待判断的点数组
     * @param range      指定范围(m)
     * @param longtitudeName 经度字段名
     * @parma latitudeName   维度字段名
     * */
    public static JSONArray getPointsInRange(double longtitude, double latitude, JSONArray pointsArray, double range, String longtitudeName, String latitudeName) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < pointsArray.size(); i++) {
            JSONObject point = pointsArray.getJSONObject(i);
            if (getDistance(latitude, longtitude, point.getDouble(latitudeName), point.getDouble(longtitudeName)) <= range) {
                result.add(point);
            }
        }
        return result;
    }

    /*
     * 求覆盖了点A的小区
     * @param 小区数据
     * @param 点的经度
     * @param 点的维度
     * */
    public static JSONArray getCellsCoverPoint(JSONArray stationCells, double longtitude, double latitude) {
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < stationCells.size(); i++) {
            JSONObject cell = stationCells.getJSONObject(i);
            if (isContainInSector(longtitude, latitude, cell.getDouble("longtitute"), cell.getDouble("lattitute"), 400D, cell.getDouble("azimuth"), 65D)) {
                resultArray.add(cell);
            }
        }
        return resultArray;
    }

    /**
     * @param distance 距离
     * @return int      TA值
     * @description TA表征的是UE与天线端口之间的距离。
     **/
    public static int getTAByDistance(double distance) {
        int TA = 0;
        if (distance <= 78.12) {
            TA = 1;
        } else if (distance <= 234.36) {
            TA = 3;
        } else if (distance <= 390.6) {
            TA = 5;
        } else if (distance <= 546.84) {
            TA = 7;
        } else if (distance <= 703.08) {
            TA = 9;
        } else if (distance <= 859.32) {
            TA = 11;
        } else if (distance <= 1015.56) {
            TA = 13;
        } else if (distance <= 1562.4) {
            TA = 20;
        } else if (distance <= 2109.24) {
            TA = 27;
        } else if (distance <= 2656.08) {
            TA = 34;
        } else if (distance <= 3124.8) {
            TA = 40;
        } else if (distance <= 3906) {
            TA = 50;
        } else if (distance <= 6327.72) {
            TA = 81;
        }
        return TA;
    }

    /**
     * 判断点在面内工具
     *
     * @param ALon
     * @param ALat
     * @param ps
     * @return
     */
    public static boolean isPtInPoly(double ALon, double ALat, Point2D.Double[] ps) {
        int iSum, iCount, iIndex;
        double dLon1 = 0, dLon2 = 0, dLat1 = 0, dLat2 = 0, dLon;
        if (ps.length < 3) {
            return false;
        }
        iSum = 0;
        iCount = ps.length;
        for (iIndex = 0; iIndex < iCount; iIndex++) {
            if (iIndex == iCount - 1) {
                dLon1 = ps[iIndex].getX();
                dLat1 = ps[iIndex].getY();
                dLon2 = ps[0].getX();
                dLat2 = ps[0].getY();
            } else {
                dLon1 = ps[iIndex].getX();
                dLat1 = ps[iIndex].getY();
                dLon2 = ps[iIndex + 1].getX();
                dLat2 = ps[iIndex + 1].getY();
            }
            // 以下语句判断A点是否在边的两端点的水平平行线之间，在则可能有交点，开始判断交点是否在左射线上
            if (((ALat >= dLat1) && (ALat < dLat2)) || ((ALat >= dLat2) && (ALat < dLat1))) {
                if (Math.abs(dLat1 - dLat2) > 0) {
                    //得到 A点向左射线与边的交点的x坐标：
                    dLon = dLon1 - ((dLon1 - dLon2) * (dLat1 - ALat)) / (dLat1 - dLat2);
                    // 如果交点在A点左侧（说明是做射线与 边的交点），则射线与边的全部交点数加一：
                    if (dLon < ALon) {
                        iSum++;
                    }
                }
            }
        }
        if ((iSum % 2) != 0) {
            return true;
        }
        return false;
    }


}
