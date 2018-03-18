package com.lingang.bean;

import java.util.List;

/**
 * Created by ad2040 on 2016/12/22.
 * 下载管理中，全部资料接口对应的实体
 */

public class AllDataResponse {

    /**
     * stateCode : 1000
     * message : null
     * remark : null
     * data : {"countPage":1,"countRecord":15,"currentPage":1,"list":[{"parkId":70,"parkName":"临港产业区","files":[{"fileId":281,"fileTitle":"临港产业区","imgId":1140,"imgPath":"/image/upload/img/20170407/201704071718419460.jpg","fileAddress":"/image/upload/park/20170407/201704071714234824.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491556463160,"fileSize":43,"downloadSpeed":null,"downloadState":null},{"fileId":283,"fileTitle":"画册上","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170417/201704171754428948.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1492422882643,"fileSize":7.43,"downloadSpeed":null,"downloadState":null},{"fileId":284,"fileTitle":"画册下","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170417/201704171754497041.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1492422889403,"fileSize":6.24,"downloadSpeed":null,"downloadState":null}]},{"parkId":86,"parkName":"漕河泾开发区","files":[{"fileId":266,"fileTitle":"漕河泾园区服务","imgId":969,"imgPath":"/image/upload/img/20170330/201703301241518993.png","fileAddress":"/image/upload/park/20170330/20170330120125863.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1490846486100,"fileSize":46,"downloadSpeed":null,"downloadState":null}]},{"parkId":69,"parkName":"自贸区洋山保税区","files":[{"fileId":84,"fileTitle":"自贸区洋山保税区","imgId":843,"imgPath":"/image/upload/img/20170224/201702241846081625.png","fileAddress":"/image/upload/park/20170308/201703081037348540.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488940654407,"fileSize":33,"downloadSpeed":null,"downloadState":null}]},{"parkId":90,"parkName":"临港海外创新中心","files":[{"fileId":282,"fileTitle":"临港海外创新中心","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170407/201704071822232446.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1491560544047,"fileSize":69,"downloadSpeed":null,"downloadState":null}]},{"parkId":71,"parkName":"临港松江科技城","files":[{"fileId":105,"fileTitle":"临港松江科技城","imgId":883,"imgPath":"/image/upload/img/20170307/20170307204626373.jpg","fileAddress":"/image/upload/park/20170307/201703072043049376.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488890584200,"fileSize":48,"downloadSpeed":null,"downloadState":null}]},{"parkId":89,"parkName":"临港浦江科技城","files":[{"fileId":268,"fileTitle":"浦江高科技园","imgId":1080,"imgPath":"/image/upload/img/20170407/201704071459304400.png","fileAddress":"/image/upload/park/20170407/201704071457401824.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491548260507,"fileSize":60,"downloadSpeed":null,"downloadState":null}]},{"parkId":68,"parkName":"临港奉贤园区","files":[{"fileId":76,"fileTitle":"2015临港奉贤园区宣传册","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170123/201701231008559039.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1485137335937,"fileSize":43,"downloadSpeed":null,"downloadState":null},{"fileId":106,"fileTitle":"临港奉贤智造园","imgId":884,"imgPath":"/image/upload/img/20170307/201703072049147919.jpg","fileAddress":"/image/upload/park/20170307/201703072043536422.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488890634027,"fileSize":37,"downloadSpeed":null,"downloadState":null}]},{"parkId":85,"parkName":"漕河泾南桥园区","files":[{"fileId":264,"fileTitle":"南桥开发区","imgId":955,"imgPath":"/image/upload/img/20170329/201703291616184358.png","fileAddress":"/image/upload/park/20170329/201703291546118888.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1490773571203,"fileSize":29,"downloadSpeed":null,"downloadState":null}]},{"parkId":92,"parkName":"漕河泾康桥商务绿洲","files":[{"fileId":270,"fileTitle":"漕河泾康桥商务绿洲","imgId":1081,"imgPath":"/image/upload/img/20170407/201704071500163672.png","fileAddress":"/image/upload/park/20170407/201704071500079998.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491548407743,"fileSize":36,"downloadSpeed":null,"downloadState":null}]},{"parkId":72,"parkName":"临港科技城","files":[{"fileId":85,"fileTitle":"临港科技城","imgId":850,"imgPath":"/image/upload/img/20170225/20170225094837417.png","fileAddress":"/image/upload/park/20170307/201703072041267677.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488890486967,"fileSize":36,"downloadSpeed":null,"downloadState":null}]},{"parkId":74,"parkName":"枫泾新兴产业区","files":[{"fileId":103,"fileTitle":"项目开启.txt","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170306/201703061137489491.txt","fileType":1,"fileUpdateTime":null,"updateTime":1488771468077,"fileSize":0,"downloadSpeed":null,"downloadState":null}]},{"parkId":75,"parkName":"临港再制造园区","files":[{"fileId":107,"fileTitle":"临港再制造","imgId":888,"imgPath":"/image/upload/img/20170308/201703080950327196.jpg","fileAddress":"/image/upload/park/20170308/201703080949061566.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488937746730,"fileSize":28,"downloadSpeed":null,"downloadState":null}]},{"parkId":91,"parkName":"沪苏大丰产业联动集聚区","files":[{"fileId":269,"fileTitle":"沪苏大丰宣传片","imgId":1079,"imgPath":"/image/upload/img/20170407/201704071459045788.png","fileAddress":"/image/upload/park/20170407/201704071458483162.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491548328807,"fileSize":15,"downloadSpeed":null,"downloadState":null}]},{"parkId":45,"parkName":"现代物流平台","files":[{"fileId":83,"fileTitle":"上海南港","imgId":829,"imgPath":"/image/upload/img/20170123/201701232150569974.png","fileAddress":"/image/upload/park/20170308/201703081133183985.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488943998997,"fileSize":37,"downloadSpeed":null,"downloadState":null}]},{"parkId":84,"parkName":"产城平台公司","files":[{"fileId":265,"fileTitle":"临港产城宣传片","imgId":956,"imgPath":"/image/upload/img/20170329/201703291616433138.png","fileAddress":"/image/upload/park/20170329/201703291552189602.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1490773939083,"fileSize":51,"downloadSpeed":null,"downloadState":null}]}],"onePageCount":20,"startIndex":1,"pageIndex":{"endIndex":1,"startIndex":1}}
     * dataMap : null
     */

    private String stateCode;
    private Object message;
    private Object remark;
    private DataEntity data;
    private Object dataMap;

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public Object getDataMap() {
        return dataMap;
    }

    public void setDataMap(Object dataMap) {
        this.dataMap = dataMap;
    }

    public static class DataEntity {
        /**
         * countPage : 1
         * countRecord : 15
         * currentPage : 1
         * list : [{"parkId":70,"parkName":"临港产业区","files":[{"fileId":281,"fileTitle":"临港产业区","imgId":1140,"imgPath":"/image/upload/img/20170407/201704071718419460.jpg","fileAddress":"/image/upload/park/20170407/201704071714234824.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491556463160,"fileSize":43,"downloadSpeed":null,"downloadState":null},{"fileId":283,"fileTitle":"画册上","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170417/201704171754428948.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1492422882643,"fileSize":7.43,"downloadSpeed":null,"downloadState":null},{"fileId":284,"fileTitle":"画册下","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170417/201704171754497041.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1492422889403,"fileSize":6.24,"downloadSpeed":null,"downloadState":null}]},{"parkId":86,"parkName":"漕河泾开发区","files":[{"fileId":266,"fileTitle":"漕河泾园区服务","imgId":969,"imgPath":"/image/upload/img/20170330/201703301241518993.png","fileAddress":"/image/upload/park/20170330/20170330120125863.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1490846486100,"fileSize":46,"downloadSpeed":null,"downloadState":null}]},{"parkId":69,"parkName":"自贸区洋山保税区","files":[{"fileId":84,"fileTitle":"自贸区洋山保税区","imgId":843,"imgPath":"/image/upload/img/20170224/201702241846081625.png","fileAddress":"/image/upload/park/20170308/201703081037348540.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488940654407,"fileSize":33,"downloadSpeed":null,"downloadState":null}]},{"parkId":90,"parkName":"临港海外创新中心","files":[{"fileId":282,"fileTitle":"临港海外创新中心","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170407/201704071822232446.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1491560544047,"fileSize":69,"downloadSpeed":null,"downloadState":null}]},{"parkId":71,"parkName":"临港松江科技城","files":[{"fileId":105,"fileTitle":"临港松江科技城","imgId":883,"imgPath":"/image/upload/img/20170307/20170307204626373.jpg","fileAddress":"/image/upload/park/20170307/201703072043049376.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488890584200,"fileSize":48,"downloadSpeed":null,"downloadState":null}]},{"parkId":89,"parkName":"临港浦江科技城","files":[{"fileId":268,"fileTitle":"浦江高科技园","imgId":1080,"imgPath":"/image/upload/img/20170407/201704071459304400.png","fileAddress":"/image/upload/park/20170407/201704071457401824.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491548260507,"fileSize":60,"downloadSpeed":null,"downloadState":null}]},{"parkId":68,"parkName":"临港奉贤园区","files":[{"fileId":76,"fileTitle":"2015临港奉贤园区宣传册","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170123/201701231008559039.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1485137335937,"fileSize":43,"downloadSpeed":null,"downloadState":null},{"fileId":106,"fileTitle":"临港奉贤智造园","imgId":884,"imgPath":"/image/upload/img/20170307/201703072049147919.jpg","fileAddress":"/image/upload/park/20170307/201703072043536422.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488890634027,"fileSize":37,"downloadSpeed":null,"downloadState":null}]},{"parkId":85,"parkName":"漕河泾南桥园区","files":[{"fileId":264,"fileTitle":"南桥开发区","imgId":955,"imgPath":"/image/upload/img/20170329/201703291616184358.png","fileAddress":"/image/upload/park/20170329/201703291546118888.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1490773571203,"fileSize":29,"downloadSpeed":null,"downloadState":null}]},{"parkId":92,"parkName":"漕河泾康桥商务绿洲","files":[{"fileId":270,"fileTitle":"漕河泾康桥商务绿洲","imgId":1081,"imgPath":"/image/upload/img/20170407/201704071500163672.png","fileAddress":"/image/upload/park/20170407/201704071500079998.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491548407743,"fileSize":36,"downloadSpeed":null,"downloadState":null}]},{"parkId":72,"parkName":"临港科技城","files":[{"fileId":85,"fileTitle":"临港科技城","imgId":850,"imgPath":"/image/upload/img/20170225/20170225094837417.png","fileAddress":"/image/upload/park/20170307/201703072041267677.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488890486967,"fileSize":36,"downloadSpeed":null,"downloadState":null}]},{"parkId":74,"parkName":"枫泾新兴产业区","files":[{"fileId":103,"fileTitle":"项目开启.txt","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170306/201703061137489491.txt","fileType":1,"fileUpdateTime":null,"updateTime":1488771468077,"fileSize":0,"downloadSpeed":null,"downloadState":null}]},{"parkId":75,"parkName":"临港再制造园区","files":[{"fileId":107,"fileTitle":"临港再制造","imgId":888,"imgPath":"/image/upload/img/20170308/201703080950327196.jpg","fileAddress":"/image/upload/park/20170308/201703080949061566.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488937746730,"fileSize":28,"downloadSpeed":null,"downloadState":null}]},{"parkId":91,"parkName":"沪苏大丰产业联动集聚区","files":[{"fileId":269,"fileTitle":"沪苏大丰宣传片","imgId":1079,"imgPath":"/image/upload/img/20170407/201704071459045788.png","fileAddress":"/image/upload/park/20170407/201704071458483162.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491548328807,"fileSize":15,"downloadSpeed":null,"downloadState":null}]},{"parkId":45,"parkName":"现代物流平台","files":[{"fileId":83,"fileTitle":"上海南港","imgId":829,"imgPath":"/image/upload/img/20170123/201701232150569974.png","fileAddress":"/image/upload/park/20170308/201703081133183985.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1488943998997,"fileSize":37,"downloadSpeed":null,"downloadState":null}]},{"parkId":84,"parkName":"产城平台公司","files":[{"fileId":265,"fileTitle":"临港产城宣传片","imgId":956,"imgPath":"/image/upload/img/20170329/201703291616433138.png","fileAddress":"/image/upload/park/20170329/201703291552189602.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1490773939083,"fileSize":51,"downloadSpeed":null,"downloadState":null}]}]
         * onePageCount : 20
         * startIndex : 1
         * pageIndex : {"endIndex":1,"startIndex":1}
         */

        private int countPage;
        private int countRecord;
        private int currentPage;
        private int onePageCount;
        private int startIndex;
        private PageIndexEntity pageIndex;
        private List<ListEntity> list;

        public int getCountPage() {
            return countPage;
        }

        public void setCountPage(int countPage) {
            this.countPage = countPage;
        }

        public int getCountRecord() {
            return countRecord;
        }

        public void setCountRecord(int countRecord) {
            this.countRecord = countRecord;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getOnePageCount() {
            return onePageCount;
        }

        public void setOnePageCount(int onePageCount) {
            this.onePageCount = onePageCount;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public PageIndexEntity getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(PageIndexEntity pageIndex) {
            this.pageIndex = pageIndex;
        }

        public List<ListEntity> getList() {
            return list;
        }

        public void setList(List<ListEntity> list) {
            this.list = list;
        }

        public static class PageIndexEntity {
            /**
             * endIndex : 1
             * startIndex : 1
             */

            private int endIndex;
            private int startIndex;

            public int getEndIndex() {
                return endIndex;
            }

            public void setEndIndex(int endIndex) {
                this.endIndex = endIndex;
            }

            public int getStartIndex() {
                return startIndex;
            }

            public void setStartIndex(int startIndex) {
                this.startIndex = startIndex;
            }
        }

        public static class ListEntity {
            /**
             * parkId : 70
             * parkName : 临港产业区
             * files : [{"fileId":281,"fileTitle":"临港产业区","imgId":1140,"imgPath":"/image/upload/img/20170407/201704071718419460.jpg","fileAddress":"/image/upload/park/20170407/201704071714234824.mp4","fileType":2,"fileUpdateTime":null,"updateTime":1491556463160,"fileSize":43,"downloadSpeed":null,"downloadState":null},{"fileId":283,"fileTitle":"画册上","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170417/201704171754428948.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1492422882643,"fileSize":7.43,"downloadSpeed":null,"downloadState":null},{"fileId":284,"fileTitle":"画册下","imgId":null,"imgPath":null,"fileAddress":"/image/upload/park/20170417/201704171754497041.pdf","fileType":1,"fileUpdateTime":null,"updateTime":1492422889403,"fileSize":6.24,"downloadSpeed":null,"downloadState":null}]
             */

            private int parkId;
            private String parkName;
            private List<FilesEntity> files;

            public int getParkId() {
                return parkId;
            }

            public void setParkId(int parkId) {
                this.parkId = parkId;
            }

            public String getParkName() {
                return parkName;
            }

            public void setParkName(String parkName) {
                this.parkName = parkName;
            }

            public List<FilesEntity> getFiles() {
                return files;
            }

            public void setFiles(List<FilesEntity> files) {
                this.files = files;
            }

            public static class FilesEntity {
                /**
                 * fileId : 281
                 * fileTitle : 临港产业区
                 * imgId : 1140
                 * imgPath : /image/upload/img/20170407/201704071718419460.jpg
                 * fileAddress : /image/upload/park/20170407/201704071714234824.mp4
                 * fileType : 2
                 * fileUpdateTime : null
                 * updateTime : 1491556463160
                 * fileSize : 43.0
                 * downloadSpeed : null
                 * downloadState : null
                 */

                private int fileId;
                private String fileTitle;
                private int imgId;
                private String imgPath;
                private String fileAddress;
                private int fileType;
                private Object fileUpdateTime;
                private long updateTime;
                private double fileSize;
                private Object downloadSpeed;
                private Object downloadState;

                public FilesEntity() {
                }

                public FilesEntity(String fileTitle, String fileAddress, int fileType) {
                    this.fileTitle = fileTitle;
                    this.fileAddress = fileAddress;
                    this.fileType = fileType;
                }

                public int getFileId() {
                    return fileId;
                }

                public void setFileId(int fileId) {
                    this.fileId = fileId;
                }

                public String getFileTitle() {
                    return fileTitle;
                }

                public void setFileTitle(String fileTitle) {
                    this.fileTitle = fileTitle;
                }

                public int getImgId() {
                    return imgId;
                }

                public void setImgId(int imgId) {
                    this.imgId = imgId;
                }

                public String getImgPath() {
                    return imgPath;
                }

                public void setImgPath(String imgPath) {
                    this.imgPath = imgPath;
                }

                public String getFileAddress() {
                    return fileAddress;
                }

                public void setFileAddress(String fileAddress) {
                    this.fileAddress = fileAddress;
                }

                public int getFileType() {
                    return fileType;
                }

                public void setFileType(int fileType) {
                    this.fileType = fileType;
                }

                public Object getFileUpdateTime() {
                    return fileUpdateTime;
                }

                public void setFileUpdateTime(Object fileUpdateTime) {
                    this.fileUpdateTime = fileUpdateTime;
                }

                public long getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(long updateTime) {
                    this.updateTime = updateTime;
                }

                public double getFileSize() {
                    return fileSize;
                }

                public void setFileSize(double fileSize) {
                    this.fileSize = fileSize;
                }

                public Object getDownloadSpeed() {
                    return downloadSpeed;
                }

                public void setDownloadSpeed(Object downloadSpeed) {
                    this.downloadSpeed = downloadSpeed;
                }

                public Object getDownloadState() {
                    return downloadState;
                }

                public void setDownloadState(Object downloadState) {
                    this.downloadState = downloadState;
                }
            }
        }
    }
}
