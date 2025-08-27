# MySQL DB 생성, 계정 권한 부여

---

## 1단계: MySQL root 계정으로 로그인

```sql
mysql -u root -p
```

## 2단계: 데이터베이스 및 사용자 계정 생성

1. 데이터베이스 생성 (이름: webdb)
```sql
CREATE DATABASE webdb;
```

2. 사용자 계정 생성 (이름: webdb / 비밀번호: webdb)

- 192.168로 시작하는 모든 ip에서 접속할 수 있는 사용자를 생성
```sql
CREATE USER 'webdb'@'192.168.%' IDENTIFIED BY 'webdb';
```
## 3단계: 사용자에게 권한 부여 (GRANT)

-- webdb 데이터베이스의 모든 테이블(*)에 대한 모든 권한(ALL PRIVILEGES)을 부여
```sql
GRANT ALL PRIVILEGES ON webdb.* TO 'webdb'@'192.168.%';
```

-- 변경된 권한 설정을 MySQL 서버에 반영
```sql
FLUSH PRIVILEGES;
```

