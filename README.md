# Project Title

## Getting Started

學習spring data jpa，根據條件至資料庫取得資料，前端配合Angular6

### Prerequisites

* 根據上行json，建立java相關物件

```json
{
    "header": {
        "msgId": "1",
        "txnSeq": "2",
        "branchId": "3",
        "clientIp": "4"
    },
    "body": {
     "customerId": "1",
                "name": "JOY",
                "addr": "上海",
                "age": "16",
                "tel": "0912345678"
    }
}
```

* 資料庫同樣原配制是h2資料庫

假資料
CREATE TABLE `CUSTOMER_NEW` (
  CUSTOMER_ID VARCHAR NOT NULL PRIMARY KEY,
  NAME VARCHAR(10) ,
  ADDR  VARCHAR(10) ,
  AGE VARCHAR(10) ,
  TEL VARCHAR(10)
);

INSERT INTO CUSTOMER_NEW VALUES(1,'JOY','上海','16','0912345678');
INSERT INTO CUSTOMER_NEW VALUES(2,'KID','武漢','17','0945678912');
INSERT INTO CUSTOMER_NEW VALUES(3,'DUKE','合肥','18','0956789000');
INSERT INTO CUSTOMER_NEW VALUES(4,'TOM','台東','19','096666666');
INSERT INTO CUSTOMER_NEW VALUES(5,'MARRY','花蓮','20','0977777777');
INSERT INTO CUSTOMER_NEW VALUES(6,'DAVID','澎湖','21','0956888888');
INSERT INTO CUSTOMER_NEW VALUES(7,'ALEX','桃園','22','0912999999');



SELECT * FROM MERCHANT 

DROP TABLE MERCHANT 

CREATE TABLE MERCHANT (
  MERCHANTID  VARCHAR NOT NULL PRIMARY KEY,
  NAME VARCHAR(10) ,
  TEL VARCHAR(10) ,
  ADDR VARCHAR(10),
  PIC  BLOB
);

INSERT INTO MERCHANT VALUES('1','JOY','0912345678','上海','');

