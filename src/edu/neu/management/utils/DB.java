package edu.neu.management.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import edu.neu.management.bean.Lesson;
import edu.neu.management.bean.Lessonmanage;
import edu.neu.management.bean.User;
import java.util.*;
import java.sql.*;
import edu.neu.management.LoginServlet;

public class DB {
    public static String queryRole(User user) {
        String identity = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            String sql = "select identity from world.user where username='" + user.getUsername() + "' and password='" + user.getPassword() + "'";
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            resultSet.next();
            identity = resultSet.getString("identity");
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return identity;
    }

    public static List<Lessonmanage> queryLesson_Name() {
        String sql = "select lessonname,teacher,manager from world.lessonmanage";
        ArrayList<Lessonmanage> list = new ArrayList<>();
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String lessonName = resultSet.getString("lessonname");
                String teacher = resultSet.getString("teacher");
                String manager = resultSet.getString("manager");
                Lessonmanage lessonmanage = new Lessonmanage();
                lessonmanage.setLessonname(lessonName);
                lessonmanage.setTeacher(teacher);
                lessonmanage.setManager(manager);
                list.add(lessonmanage);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> get_AllLesson() {
        String sql = "select lessonname from world.lessonmanage";
        ArrayList<String> list = new ArrayList<>();
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String lessonName = resultSet.getString("lessonname");
                list.add(lessonName);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Lesson> AllLsson() {
        String sql = "select code,LessonName,applicant, sdata,sdata2,applyreason,reason1,reason2 from world.lesson ";
        ArrayList<Lesson> list = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant = resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");
                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Lesson> AllpassLsson() {
        String sql = "select code,LessonName,applicant, sdata,sdata2,applyreason,reason1,reason2 from world.lesson where sdata='pass'and sdata2='pass'";
        ArrayList<Lesson> list = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant = resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");
                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<User> getAlluser() {
        String sql = "select username,password,identity from world.user";
        ArrayList<User> list = null;
        //System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String identity = resultSet.getString("identity");
                User user=new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setIdentity(identity);
                list.add(user);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Lesson> queryManagerLesson(String manager) {
        String sql = "select code,lesson.LessonName,applicant, sdata,sdata2,applyreason from world.lesson,world.lessonmanage where lesson.LessonName=lessonmanage.lessonname and lessonmanage.manager='" + manager + "'" +
                "and sdata2 is null";
        ArrayList<Lesson> list = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant = resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                //System.out.println(code);
                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> selectTeacherLesson(String teachername) {
        String sql = "select lessonmanage.lessonname from world.lessonmanage where lessonmanage.teacher='" + teachername + "'";
        ArrayList<String> list = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String lessonName = resultSet.getString("lessonname");
                list.add(lessonName);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<String> selectManagerLesson(String manager) {
        String sql = "select lessonmanage.lessonname from world.lessonmanage where lessonmanage.manager='" + manager+ "'";
        ArrayList<String> list = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String lessonName = resultSet.getString("lessonname");
                list.add(lessonName);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Lesson> queryTeacherLesson(String teachername) {
        String sql = "select code,lesson.LessonName,applicant, sdata,sdata2,applyreason from world.lesson,world.lessonmanage where lesson.LessonName=lessonmanage.lessonname and lessonmanage.teacher='" + teachername + "'and sdata is null";
        ArrayList<Lesson> list = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant = resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                //System.out.println(code);
                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Lesson> queryByname(String applicant) {
        String sql = "select code, LessonName, sdata,sdata2,applyreason ,reason1,reason2,conform from world.lesson where applicant='" + applicant + "'and conform is null";
        ArrayList<Lesson> list = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");
                String conform=resultSet.getString("conform");

                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lesson.setConform(conform);

                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Lesson> queryAll(String applicant) {
        String sql = "select code, LessonName, sdata,sdata2,applyreason ,reason1,reason2,conform from world.lesson where applicant='" + applicant + "'";
        ArrayList<Lesson> list = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");
                String conform=resultSet.getString("conform");
                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lesson.setConform(conform);

                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> queryByAll(String applicant) {
        String sql = "select code, LessonName, sdata,sdata2,applyreason ,reason1,reason2,conform from world.lesson where applicant='" + applicant + "'";
        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");
                String conform=resultSet.getString("conform");

                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lesson.setConform(conform);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean addLesson(Lesson lesson) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "insert into world.lesson (code,LessonName, applicant,sdata,sdata2,applyreason,reason1,reason2,conform) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, lesson.getCode());
            preparedStatement.setString(2, lesson.getLessonname());
            preparedStatement.setString(3, lesson.getApplicant());
            preparedStatement.setString(4, lesson.getSdata());
            preparedStatement.setString(5, lesson.getSdata2());
            preparedStatement.setString(6, lesson.getApplyreason());
            preparedStatement.setString(7, lesson.getReason1());
            preparedStatement.setString(8, lesson.getReason2());
            preparedStatement.setString(9, lesson.getConform());

            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean adduser(User user) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "insert into world.user (username,password,identity) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getIdentity());
            flag = preparedStatement.execute();
            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean addlessons(Lessonmanage lessonmanage) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "insert into world.lessonmanage (lessonname,teacher,manager) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, lessonmanage.getLessonname());
            preparedStatement.setString(2, lessonmanage.getTeacher());
            preparedStatement.setString(3, lessonmanage.getManager());
            flag = preparedStatement.execute();
            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteUser(User user) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "delete from world.user where username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, user.getUsername());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteLesson(Lesson lesson) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "delete from world.lesson where code=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, lesson.getCode());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteLessonBYadmin(Lessonmanage lessonmanage) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "delete from world.lessonmanage where lessonname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, lessonmanage.getLessonname());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean updateLesson(Lesson lesson) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "update world.lesson set LessonName=? where code=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);

            preparedStatement.setString(1, lesson.getLessonname());
            preparedStatement.setString(2, lesson.getCode());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean updateLessonbyadmins(Lessonmanage lessonmanage) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "update world.lessonmanage set teacher=?,manager=? where lessonname=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);
            preparedStatement.setString(1, lessonmanage.getTeacher());
            preparedStatement.setString(2, lessonmanage.getManager());
            preparedStatement.setString(3,lessonmanage.getLessonname());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean updateUser(User user) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "update world.user set password=?,identity=? where username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);

            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getIdentity());
            preparedStatement.setString(3,user.getUsername());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean conformLesson(Lesson lesson) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            String sql = "update world.lesson set conform='a' where code=? and sdata is not null and sdata2 is not null";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
            preparedStatement.setString(1, lesson.getConform());
            preparedStatement.setString(1, lesson.getCode());
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount()!=0)
                flag=true;

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Lesson queryByCode(Lesson lesson) {
        String sql = "select code, LessonName, applicant from world.lesson where code='" + lesson.getCode() + "'";
        //System.out.println(sql);
        Lesson retLesson = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            if (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonname = resultSet.getString("name");
                String applicant = resultSet.getString("applicant");
                //System.out.println(code + ":" + name + ":" + surface);
                retLesson = new Lesson();
                retLesson.setCode(code);
                retLesson.setLessonname(lessonname);
                retLesson.setApplicant(applicant);
            }

            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(retCountry.toString());
        return retLesson;
    }

    public static List<List<Lesson>> teacherlesson(String teacher) {
        String sql = "select code,lesson.LessonName,applicant, sdata,sdata2,applyreason ,reason1,reason2 from world.lesson,world.lessonmanage where lesson.LessonName=lessonmanage.lessonname and lessonmanage.teacher='" + teacher + "'and sdata is not null";

        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant=resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> managerlesson(String manager) {
        String sql = "select code,lesson.LessonName,applicant, sdata,sdata2,applyreason ,reason1,reason2 from world.lesson,world.lessonmanage where lesson.LessonName=lessonmanage.lessonname and lessonmanage.manager='" + manager + "'and sdata2 is not null";

        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant=resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> Select_teacherlesson_byLessonName(String lessonname,String teacher) {
        String sql = "select code,lesson.LessonName,applicant, sdata,applyreason ,reason1 from world.lesson,world.lessonmanage " +
                "where lesson.LessonName=lessonmanage.lessonname and lessonmanage.teacher='" + teacher + "'and lesson.LessonName='"+lessonname+"'and sdata is not null ";
        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String sdate = resultSet.getString("sdata");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setSdata(sdate);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> Select_managerlesson_byLessonName(String lessonname,String manager) {
        String sql = "select code,lesson.LessonName,applicant, sdata,sdata2,applyreason ,reason1,reason2 from world.lesson,world.lessonmanage " +
                "where lesson.LessonName=lessonmanage.lessonname and lessonmanage.manager='" + manager + "'and lesson.LessonName='"+lessonname+"'and sdata2 is not null";
        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> Select_managerlesson_byStudentName(String student,String manager) {
        String sql = "select code,lesson.LessonName,applicant, sdata,sdata2,applyreason ,reason1,reason2 from world.lesson,world.lessonmanage " +
                "where lesson.LessonName=lessonmanage.lessonname and lessonmanage.manager='" + manager + "'and lesson.applicant='"+student+"'and sdata2 is not null";
        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> Select_studentlesson_byLessonName(String lessonname,String student) {
        String sql = "select code, lesson.LessonName, applicant, sdata, sdata2, applyreason, reason1, reason2, conform from world.lesson " +
                "where  lesson.applicant='" + student + "'and lesson.LessonName='"+lessonname+"' ";
        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        //System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant=resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String sdate2 = resultSet.getString("sdata2");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");
                String reason2=resultSet.getString("reason2");
                String conform=resultSet.getString("conform");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setSdata2(sdate2);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lesson.setReason2(reason2);
                lesson.setConform(conform);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<List<Lesson>> Select_teacherlesson_byStudentName(String student,String teacher) {
        String sql = "select code,lesson.LessonName,applicant, sdata,applyreason ,reason1 from world.lesson,world.lessonmanage " +
                "where lesson.LessonName=lessonmanage.lessonname and lessonmanage.teacher='" + teacher + "'and lesson.applicant='"+student+"'and sdata is not null";
        List<List<Lesson>> list = null;
        ArrayList<Lesson>lessons = null;
        System.out.println(sql);
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            list = new ArrayList<>();
            lessons = new ArrayList<>();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant=resultSet.getString("applicant");
                String sdate = resultSet.getString("sdata");
                String applyreason = resultSet.getString("applyreason");
                String reason1=resultSet.getString("reason1");


                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdate);
                lesson.setApplyreason(applyreason);
                lesson.setReason1(reason1);
                lessons.add(lesson);
                if(lessons.size()==2){
                    list.add(lessons);
                    lessons = new ArrayList<>();
                }
            }
            if(lessons.size()!=0){
                list.add(lessons);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static List<Lesson> searchPass(String value, String type) {
        String sql = "select * from world.lesson";
        if (type.equals("lessonname"))
            sql = "select code,LessonName,applicant,sdata from world.lesson where sdata='pass' and LessonName='" + value + "'";
        ArrayList<Lesson> list = new ArrayList<>();
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonName = resultSet.getString("LessonName");
                String applicant = resultSet.getString("applicant");
                String sdata = resultSet.getString("sdata");
                Lesson lesson = new Lesson();
                lesson.setCode(code);
                lesson.setLessonname(lessonName);
                lesson.setApplicant(applicant);
                lesson.setSdata(sdata);
                list.add(lesson);
            }
            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean approval(Lesson lesson) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "update world.lesson set sdata=?,reason1=? where code=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);

            preparedStatement.setString(1, lesson.getSdata());
            //System.out.println(lesson.getLessonname());
            preparedStatement.setString(2, lesson.getReason1());
            preparedStatement.setString(3, lesson.getCode());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean approval2(Lesson lesson) {
        boolean flag = false;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
//            Statement statement = connection.createStatement();
            String sql = "update world.lesson set sdata2=?,reason2=? where code=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5. 执行Statement
//            ResultSet resultSet = statement.executeQuery(sql);

            preparedStatement.setString(1, lesson.getSdata2());
            preparedStatement.setString(2, lesson.getReason2());
            preparedStatement.setString(3, lesson.getCode());
            flag = preparedStatement.execute();

            // 7. 释放资源
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Lesson checkByCode(Lesson lesson) {
        String sql = "select code, LessonName, sdata,sdata2 from world.lesson where code='" + lesson.getCode() + "'";
        //System.out.println(sql);
        Lesson retLesson = null;
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义连接
            String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf-8&serverTimezone=GMT%2B8";
            // 3. 获取数据库连接
            Connection connection = DriverManager.getConnection(
                    url,
                    "root",
                    "20216713");
            // 4. 创建Statement
            Statement statement = connection.createStatement();
            // 5. 执行Statement
            ResultSet resultSet = statement.executeQuery(sql);
            // 6. 处理结果集
            if (resultSet.next()) {
                String code = resultSet.getString("code");
                String lessonname = resultSet.getString("lessonname");
                String sdata = resultSet.getString("sdata");
                String sdata2 = resultSet.getString("sdata2");

                retLesson = new Lesson();
                retLesson.setCode(code);
                retLesson.setLessonname(lessonname);
                retLesson.setSdata(sdata);
                retLesson.setSdata2(sdata2);
            }

            // 7. 释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retLesson;
    }
}
