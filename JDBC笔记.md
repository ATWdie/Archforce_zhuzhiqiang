## JDBC笔记

### 1.什么是JDBC

​	DBC 指 Java 数据库连接，是一种标准Java应用编程接口（ JAVA API），用来连接 Java 编程语言和广泛的数据库。

​	JDBC API 库包含下面提到的每个任务，都是与数据库相关的常用用法。

- 制作到数据库的连接。
- 创建 SQL 或 MySQL 语句。
- 执行 SQL 或 MySQL 查询数据库。
- 查看和修改所产生的记录。

​    从根本上来说，JDBC 是一种规范，它提供了一套完整的接口，允许便携式访问到底层数据库，因此可以用 Java 编写不同类型的可执行文件，例如：

- Java 应用程序

- Java Applets

- Java Servlets

- Java ServerPages (JSPs)

- Enterprise JavaBeans (EJBs)

  所有这些不同的可执行文件就可以使用 JDBC 驱动程序来访问数据库，这样可以方便的访问数据。

​    JDBC 具有 ODBC 一样的性能，允许 Java 程序包含与数据库无关的代码。

### 2.常用的JDBC组件

JDBC 的 API 提供了以下接口和类：

- **DriverManager ：**这个类管理一系列数据库驱动程序。匹配连接使用通信子协议从 JAVA 应用程序中请求合适的数据库驱动程序。识别 JDBC 下某个子协议的第一驱动程序将被用于建立数据库连接。
- **Driver :** 这个接口处理与数据库服务器的通信。你将很少直接与驱动程序互动。相反，你使用 DriverManager 中的对象，它管理此类型的对象。它也抽象与驱动程序对象工作相关的详细信息。
- **Connection :** 此接口具有接触数据库的所有方法。该连接对象表示通信上下文，即，所有与数据库的通信仅通过这个连接对象进行。
- **Statement :** 使用创建于这个接口的对象将 SQL 语句提交到数据库。除了执行存储过程以外，一些派生的接口也接受参数。
- **ResultSet :** 在你使用语句对象执行 SQL 查询后，这些对象保存从数据获得的数据。它作为一个迭代器，让您可以通过它的数据来移动。
- **SQLException :** 这个类处理发生在数据库应用程序的任何错误。

### 3.创建一个JDBC应用程序

构建一个 JDBC 应用程序包括以下六个步骤：

#### 3.1 导入数据包

​	导入含有需要进行数据库编程的 JDBC 类的包。大多数情况下，使用 *import java.sql.* 就足够了。

#### 3.2 注册 JDBC 驱动器

​	初始化一个驱动器，以便于打开一个与数据库的通信通道。

```java
//注册一个驱动程序中最常用的方法是使用 Java 的Class.forName() 方法来动态加载驱动程序的类文件到内存中，它会自动将其注册。这种方法更优越一些，因为它允许你对驱动程序的注册信息进行配置，便于移植。
Class.forName(JDBC_DRIVER);
//注册一个驱动程序的第二种方法是使用静态 staticDriverManager.registerDriver() 方法
Driver myDriver = new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver( myDriver );
```

#### 3.3 打开连接

​	使用 *DriverManager.getConnection()* 方法创建一个 Connection 对象，它代表与数据库的物理连接。

```java
//第一种方式:使用数据库 URL 的用户名和密码
String URL = "jdbc:oracle:thin:@amrood:1521:EMP";
String USER = "username";
String PASS = "password";
Connection conn = DriverManager.getConnection(URL, USER, PASS);

//第二种方式:只使用数据库 URL
String URL = "jdbc:oracle:thin:username/password@amrood:1521:EMP";
Connection conn = DriverManager.getConnection(URL);

//第三种方式:使用数据库 URL 和 Properties 对象
//Properties 对象保存了一组关键数值。它通过调用 getConnection() 方法，将驱动程序属性传递给驱动程序。
String URL = "jdbc:oracle:thin:@amrood:1521:EMP";
Properties info = new Properties( );
info.put( "user", "username" );
info.put( "password", "password" );
Connection conn = DriverManager.getConnection(URL, info);
```



#### 3.4 执行查询

​	使用类型声明的对象建立并提交一个 SQL 语句到数据库。

​	JDBC 的 Statement，CallableStatement 和 PreparedStatement 接口定义的方法和属性，可以发送 SQL 命令或 PL/SQL 命令到数据库，并从数据库接收数据。

| 接口              | 推荐使用                                                     |
| :---------------- | :----------------------------------------------------------- |
| Statement         | 可以正常访问数据库，适用于运行静态 SQL 语句。 Statement 接口不接受参数。 |
| PreparedStatement | 计划多次使用 SQL 语句， PreparedStatement 接口运行时接受输入的参数。 |
| CallableStatement | 适用于当你要访问数据库存储过程的时候， CallableStatement 接口运行时也接受输入的参数。 |

##### 3.4.1 Statement

```java
//创建 Statement 对象
Statement stmt = null;
stmt = connection.createStatement();
```

当创建了一个 Statement 对象之后，可以用它的三个执行方法的任一方法来执行 SQL 语句。

- **boolean execute(String SQL) :** 如果 ResultSet 对象可以被检索，则返回的布尔值为 true ，否则返回 false 。当你需要使用真正的动态 SQL 时，可以使用这个方法来执行 SQL DDL 语句。
- **int executeUpdate(String SQL) :** 返回执行 SQL 语句影响的行的数目。使用该方法来执行 SQL 语句，是希望得到一些受影响的行的数目，例如，INSERT，UPDATE 或 DELETE 语句。
- **ResultSet executeQuery(String SQL) :** 返回一个 ResultSet 对象。当你希望得到一个结果集时使用该方法，就像你使用一个 SELECT 语句。

##### 3.4.2 PreparedStatement

```java
//创建 PreparedStatement 对象
String SQL = "INSERT INTO Employees (id,first,last,age)" +
                        "VALUES(?,?,?,?)";
//create PrepareStatement object
PreparedStatement pstmt = conn.prepareStatement(SQL);
pstmt.setInt(1, 110);
pstmt.setString(2, "aah");
pstmt.setString(3, "bobby");
pstmt.setInt(4, 87);
//add in the batch
pstmt.addBatch();

//Create an int[] to hold returned values
int[] count = pstmt.executeBatch();
```



#### 3.5 提取结果数据

​	使用适当的 *ResultSet.getXXX()* 方法从结果集中检索数据。

 	*java.sql.ResultSet* 接口表示一个数据库查询的结果集。一个 ResultSet 对象控制一个光标指向当前行的结果集。术语“结果集”是指包含在 ResultSet 对象中的行和列的数据。

ResultSet 接口的方法可细分为三类-

- **导航方法：**用于移动光标。
- **获取方法：**用于查看当前行被光标所指向的列中的数据。
- **更新方法：**用于更新当前行的列中的数据。这些更新也会更新数据库中的数据。

##### 3.5.1 ResultSet 的类型

ResultSetType 如下所示。如果你不指定 ResultSet 类型，将自动获得的值是TYPE_FORWARD_ONLY。

| 类型                              | 描述                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| ResultSet.TYPE_FORWARD_ONLY       | 光标只能在结果集中向前移动。                                 |
| ResultSet.TYPE_SCROLL_INSENSITIVE | 光标可以向前和向后移动。当结果集创建后，其他人对数据库的操作不会影响结果集的数据。 |
| ResultSet.TYPE_SCROLL_SENSITIVE.  | 光标可以向前和向后移动。当结果集创建后，其他人对数据库的操作会影响结果集的数据。 |

##### 3.5.2 ResultSet 的并发性

RSConcurrency 的值如下所示，如果你不指定并发类型，将自动获得的值是 CONCUR_READ_ONLY。

| 并发性                     | 描述                               |
| -------------------------- | ---------------------------------- |
| ResultSet.CONCUR_READ_ONLY | 创建一个只读结果集，这是默认的值。 |
| ResultSet.CONCUR_UPDATABLE | 创建一个可修改的结果集。           |

```java
//初始化一个 Statement 对象来创建一个只能前进，而且只读的 ResultSet 对象-
Statement stmt = conn.createStatement(
                           ResultSet.TYPE_FORWARD_ONLY,
                           ResultSet.CONCUR_READ_ONLY);
```

##### 3.5.3 导航结果集

在 ResultSet 接口中包括如下几种方法涉及移动光标-

| S.N. | 方法 & 描述                                                  |
| ---- | ------------------------------------------------------------ |
| 1    | **public void beforeFirst() throws SQLException**将光标移动到第一行之前。 |
| 2    | **public void afterLast() throws SQLException**将光标移动到最后一行之后。 |
| 3    | **public boolean first() throws SQLException**将光标移动到第一行。 |
| 4    | **public void last() throws SQLException**将光标移动到最后一行。 |
| 5    | **public boolean absolute(int row) throws SQLException**将光标移动到指定的第 row 行。 |
| 6    | **public boolean relative(int row) throws SQLException**将光标移动到当前指向的位置往前或往后第 row 行的位置。 |
| 7    | **public boolean previous() throws SQLException**将光标移动到上一行，如果超过结果集的范围则返回 false。 |
| 8    | **public boolean next() throws SQLException**将光标移动到下一行，如果是结果集的最后一行则返回 false。 |
| 9    | **public int getRow() throws SQLException**返回当前光标指向的行数的值。 |
| 10   | **public void moveToInsertRow() throws SQLException**将光标移动到结果集中指定的行，可以在数据库中插入新的一行。当前光标位置将被记住。 |
| 11   | **public void moveToCurrentRow() throws SQLException**如果光标处于插入行，则将光标返回到当前行，其他情况下，这个方法不执行任何操作。 |

##### 3.5.4 查看结果集

ResultSet接口中含有几十种从当前行获取数据的方法。

每个可能的数据类型都有一个 get 方法，并且每个 get 方法有两个版本-

- 一个需要列名。
- 一个需要列的索引。

例如，如果想查看的列包含一个 int 类型，需要在 ResultSet 中调用 getInt()方法-

| S.N. | 方法 & 描述                                                  |
| ---- | ------------------------------------------------------------ |
| 1    | **public int getInt(String columnName) throws SQLException**返回当前行中名为 columnName 的列的 int 值。 |
| 2    | **public int getInt(int columnIndex) throws SQLException**返回当前行中指定列的索引的 int 值。列索引从 1 开始，意味着行中的第一列是 1 ，第二列是 2 ，以此类推。 |

##### 3.5.5 更新结果集

ResultSet 接口包含了一系列的更新方法，该方法用于更新结果集中的数据。

用 get 方法可以有两个更新方法来更新任一数据类型-

- 一个需要列名。
- 一个需要列的索引。

例如，要更新一个结果集的当前行的 String 列，可以使用任一如下所示的 updateString()方法-

| S.N. | 方法 & 描述                                                  |
| ---- | ------------------------------------------------------------ |
| 1    | **public void updateString(int columnIndex, String s) throws SQLException**将指定列的字符串的值改为 s。 |
| 2    | **public void updateString(String columnName, String s) throws SQLException**类似于前面的方法，不同之处在于指定的列是用名字来指定的，而不是它的索引。 |

更新数据库中一行的数据，需要调用以下的任一方法-

| S.N. | 方法 & 描述                                                  |
| ---- | ------------------------------------------------------------ |
| 1    | **public void updateRow()**通过更新数据库中相对应的行来更新当前行。 |
| 2    | **public void deleteRow()**从数据库中删除当前行。            |
| 3    | **public void refreshRow()**在结果集中刷新数据，以反映数据库中最新的数据变化。 |
| 4    | **public void cancelRowUpdates()**取消对当前行的任何修改。   |
| 5    | **public void insertRow()**在数据库中插入一行。本方法只有在光标指向插入行的时候才能被调用。 |

##### 3.5.6 处理 Null 值

SQL 使用 NULL 值和 Java 使用 null 是不同的概念。可以使用三种策略来处理 Java 中的 SQL NULL 值-

- 避免使用返回原始数据类型的 getXXX()方法。
- 使用包装类的基本数据类型，并使用 ResultSet 对象的 wasNull()方法来测试收到 getXXX()方法返回的值是否为 null，如果是 null，该包装类变量则被设置为 null。
- 使用原始数据类型和 ResultSet 对象的 wasNull()方法来测试通过 getXXX()方法返回的值，如果是 null，则原始变量应设置为可接受的值来代表 NULL。

```java
Statement stmt = conn.createStatement( );
String sql = "SELECT id, first, last, age FROM Employees";
ResultSet rs = stmt.executeQuery(sql);

int id = rs.getInt(1);
if( rs.wasNull( ) ) {
   id = 0;
}
```

### 4.JDBC事务

​	JDBC默认的模式为自动提交模式，每句SQL都是在其完成时提交到数据库。以下三种情况我们可能会想关闭自动提交模式，并管理自己的事务。

- 为了提高性能
- 为了保持业务流程的完整性
- 使用分布式事务

```java
//关闭自动提交模式
connection.setAutoCommit(false);

//当你完成了你的修改，并且要提交你的修改，可以在 connection 对象里调用 commit（）方法
connection.commit();

//另外，用名为 conn 的连接回滚数据到数据库
connection.rollback();
```

**还原点**

​	当在事务中设置一个还原点来定义一个逻辑回滚点。如果在一个还原点之后发生错误，那么可以使用 rollback 方法来撤消所有的修改或在该还原点之后所做的修改。

Connection 对象有两个新的方法来管理还原点-

- **setSavepoint(String savepointName):** 定义了一个新的还原点。它也返回一个 Savepoint 对象。
- **releaseSavepoint(Savepoint savepointName):** 删除一个还原点。请注意，它需要一个作为参数的 Savepoint 对象。这个对象通常是由 setSavepoint() 方法生成的一个还原点。
- **rollback (String savepointName)** 方法，该方法可以回滚到指定的还原点。

### 5.JDBC异常

对于 JDBC，最常见的异常是 **java.sql.SQLException**

**SQLException**方法

| 方法                           | 描述                                                         |
| ------------------------------ | ------------------------------------------------------------ |
| getErrorCode( )                | 获取与异常关联的错误号。                                     |
| getMessage( )                  | 获取 JDBC 驱动程序的错误信息，该错误是由驱动程序处理的，或者在数据库错误中获取 Oracl 错误号和错误信息。 |
| getSQLState( )                 | 获取 XOPEN SQLstate 字符串。对于 JDBC 驱动程序错误，使用该方法不能返回有用的信息。对于数据库错误，返回第五位的 XOPEN SQLstate 代码。该方法可以返回 null。 |
| getNextException( )            | 获取异常链的下一个 Exception 对象。                          |
| printStackTrace( )             | 打印当前异常或者抛出，其回溯到标准的流错误。                 |
| printStackTrace(PrintStream s) | 打印该抛出，其回溯到你指定的打印流。                         |
| printStackTrace(PrintWriter w) | 打印该抛出，其回溯到你指定的打印写入。                       |

### 6.JDBC批处理

**批处理**

批处理是指将关联的 SQL 语句组合成一个批处理，并将他们当成一个调用提交给数据库。

当一次发送多个 SQL 语句到数据库时，可以减少通信的资源消耗，从而提高了性能。

- JDBC 驱动程序不一定支持该功能。可以使用 *DatabaseMetaData.supportsBatchUpdates()* 方法来确定目标数据库是否支持批处理更新。如果JDBC驱动程序支持此功能，则该方法返回值为 true。
- Statement，PreparedStatement 和 CallableStatement 的 **addBatch()** 方法用于添加单个语句到批处理。
- **executeBatch()** 方法用于启动执行所有组合在一起的语句。
- **executeBatch()** 方法返回一个整数数组，数组中的每个元素代表了各自的更新语句的更新数目。
- 正如可以添加语句到批处理中，也可以用 **clearBatch()** 方法删除它们。此方法删除所有用 addBatch() 方法添加的语句。但是，不能有选择性地选择要删除的语句。

**批处理和Statement对象**

使用 Statement 对象来使用批处理所需要的典型步骤如下所示-

- 使用 *createStatement()* 方法创建一个 Statement 对象。
- 使用 *setAutoCommit()* 方法将自动提交设为 false。
- 被创建的 Statement 对象可以使用 *addBatch()* 方法来添加你想要的所有SQL语句。
- 被创建的 Statement 对象可以用 *executeBatch()* 将所有的 SQL 语句执行。
- 最后，使用 *commit()* 方法提交所有的更改。

**批处理和 PrepareStatement 对象**

使用 prepareStatement 对象来使用批处理需要的典型步骤如下所示-

- 使用占位符创建 SQL 语句。
- 使用任一 *prepareStatement()* 方法创建 prepareStatement 对象。
- 使用 *setAutoCommit()* 方法将自动提交设为 false。
- 被创建的 Statement 对象可以使用 *addBatch()* 方法来添加你想要的所有 SQL 语句。
- 被创建的 Statement 对象可以用 *executeBatch()* 将所有的 SQL 语句执行。
- 最后，使用 *commit()* 方法提交所有的更改。

