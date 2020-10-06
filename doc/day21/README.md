# Spring Boot 入門　

え、こんな簡単にアプリつくれちゃうの。。。
〇〇メンテナンス画面を作ろう

1. プロジェクトを作ろう 5分
2. Hello Worldページを表示する　5分
3. リストページの表示　5分
4. DBから値を取得して表示する　5分
5. jarにして起動してみよう　5分


## 1.プロジェクトを作ろう

spring initializr でプロジェクトの雛形をダウンロードする

[spring initializr](https://start.spring.io/)

- Gradle
- Java
- 2.3.4
- Java8

- Dependencies
    - Spring Boot DevTools
    - Spring Web
    - Thymeleaf
    - Oracle
    - jdbc

Eclipseにインポートする
import > Existing Gradle Project

## 2.Hello Worldページを表示する

com.example.demo.controller.DemoController

```
@Controller
public class DemoController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

```

/demo/src/main/resources/templates/hello.html

```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
</head>
<body>
	<h1>Hello world</h1>
</body>
</html>
```

課題1 :<h1>XXX List</h1>と表示されるURLが/indexのページも作成してみよう

## 3.リストページの表示
Empクラスの作成

```
public class Emp {

	private long id;
	private String name;
	
	getter/setter省略

```

list.html

```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello world</title>
</head>
<body>
	<h1>Hello List</h1>
	<table >
		<tr>
			<th>empyoee no</th>
			<th>name</th>
		</tr>
		<tr th:each="emp : ${empList}">
			<td th:text="${emp.empNo}"></td>
			<td th:text="${emp.name}"></td>
		</tr>
	</table>
</body>
</html>
```


## 5.DBから値を取得して表示する

/demo/src/main/resources/application.properties

接続先設定　posgres

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/springboot
spring.datasource.username=
spring.datasource.password=
```

接続先設定　oracle

```
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@xxx.xx.xxx.xx:1521:sid
spring.datasource.username=
spring.datasource.password=
```

EmpRepository

```
@Repository
public class EmpRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmpRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Emp> findAll() {

		List<Map<String, Object>> list = jdbcTemplate.queryForList("select id , name from emp");
		List<Emp> empList = new ArrayList<Emp>();

		for (Map<String, Object> map : list) {
			Emp emp = new Emp();
			emp.setId(((Integer) map.get("id")));
			emp.setName((String) map.get("name"));
			empList.add(emp);
		}

		return empList;

	}

}
```

課題3:自身のプロダクトの開発環境のテーブルを読みこんでみよう

## 6.jarにして起動してみよう

Window > Show View > Gradle > Gradle Tasks
build > bootJar

build > libs に demo-0.0.1-SNAPSHOT.jar が作成される

コマンドラインから以下を実行

```
java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8081 
```



