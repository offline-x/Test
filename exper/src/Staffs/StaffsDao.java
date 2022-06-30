package Staffs;

import java.sql.*;

public class StaffsDao {
    PreparedStatement pst = null;
    public void getStaffsById(Connection conn,int staff_id) {
        try {
            pst = conn.prepareStatement("SELECT * FROM staffs where staff_id=?");
           pst.setInt(1,staff_id);
            ResultSet rs = pst.executeQuery();
            // 展开结果集数据库
            if(rs.next()){
                // 通过字段检索
                staff_id  = rs.getInt("staff_id");
                String first_name = rs.getString("first_name");
                String  last_name= rs.getString("last_name");
                String   email= rs.getString("email");
                String  phone_number=rs.getString("phone_number");
                String    hire_date = rs.getString("hire_date");
                String   employment_id = rs.getString("employment_id");
                int  salary   = rs.getInt("salary");
                int  commission_pct   = rs.getInt("commission_pct");
                int   manager_id   = rs.getInt("manager_id");
                int  section_id   = rs.getInt("section_id");
                String    graduated_name = rs.getString("graduated_name");

                // 输出数据
                System.out.println("staff_id\tfirst_name\tlast_name\temail\tphone_number\thire_date\t" +
                        "employment_id\tsalary\tcommission_pct\tmanager_id\tsection_id\tgraduated_name");
                System.out.println( staff_id +"\t"+ first_name+"\t" + last_name+"\t" + email +"\t"+phone_number+"\t"
                        +hire_date+"\t" +  employment_id +"\t"+salary +"\t"+ commission_pct+"\t" + manager_id+"\t" + section_id +"\t"+ graduated_name);
            }else {System.out.println("无效的员工编号");}
            // 完成后关闭
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }
  public void getStaffByname(Connection conn,String first_name,String last_name){
      try {
          pst = conn.prepareStatement("SELECT * FROM staffs where first_name=? and last_name=?");
          pst.setString(1,first_name);
          pst.setString(2,last_name);
          ResultSet rs = pst.executeQuery();
          // 展开结果集数据库
          if(rs.next()){
              System.out.println("staff_id\tfirst_name\tlast_name\temail\tphone_number\thire_date\t" +
                      "employment_id\tsalary\tcommission_pct\tmanager_id\tsection_id\tgraduated_name");
              while(rs.next()) {
                  // 通过字段检索
                  int staff_id = rs.getInt("staff_id");
                  first_name = rs.getString("first_name");
                  last_name = rs.getString("last_name");
                  String email = rs.getString("email");
                  String phone_number = rs.getString("phone_number");
                  String hire_date = rs.getString("hire_date");
                  String employment_id = rs.getString("employment_id");
                  int salary = rs.getInt("salary");
                  int commission_pct = rs.getInt("commission_pct");
                  int manager_id = rs.getInt("manager_id");
                  int section_id = rs.getInt("section_id");
                  String graduated_name = rs.getString("graduated_name");

                  // 输出数据
                  System.out.println(staff_id + "\t" + first_name + "\t" + last_name + "\t" + email + "\t" + phone_number + "\t"
                          + hire_date + "\t" + employment_id + "\t" + salary + "\t" + commission_pct + "\t" + manager_id + "\t" + section_id + "\t" + graduated_name);
              }
          }else {System.out.println("无效的姓名");}
          // 完成后关闭
          rs.close();
          pst.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
   public void modify(Connection conn,int staff_id,String phone_number){
       try {
           pst = conn.prepareStatement("update staffs set phone_number=? where staff_id=?");
           pst.setInt(2,staff_id);
           pst.setString(1,phone_number);
           int rs = pst.executeUpdate();
           // 完成后关闭
           if(rs>0){
               System.out.println("修改成功！");
           }else { System.out.println("修改失败！");}
           pst.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
   public void getBysectionId(Connection conn,int section_id){
       try {
           pst = conn.prepareStatement("SELECT * FROM staffs where section_id=? order by staff_id");
           pst.setInt(1,section_id);
           ResultSet rs = pst.executeQuery();
           // 展开结果集数据库
           if(rs.next()){
               System.out.println("staff_id\tfirst_name\tlast_name\temail\tphone_number\thire_date\t" +
                       "employment_id\tsalary\tcommission_pct\tmanager_id\tsection_id\tgraduated_name");
               while (rs.next()) {

                   // 通过字段检索
                   int staff_id = rs.getInt("staff_id");
                   String first_name = rs.getString("first_name");
                   String last_name = rs.getString("last_name");
                   String email = rs.getString("email");
                   String phone_number = rs.getString("phone_number");
                   String hire_date = rs.getString("hire_date");
                   String employment_id = rs.getString("employment_id");
                   int salary = rs.getInt("salary");
                   int commission_pct = rs.getInt("commission_pct");
                   int manager_id = rs.getInt("manager_id");
                   section_id = rs.getInt("section_id");
                   String graduated_name = rs.getString("graduated_name");

                   // 输出数据

                   System.out.println(staff_id + "\t" + first_name + "\t" + last_name + "\t" + email + "\t" + phone_number + "\t"
                           + hire_date + "\t" + employment_id + "\t" + salary + "\t" + commission_pct + "\t" + manager_id + "\t" + section_id + "\t" + graduated_name);
               }
           }else {System.out.println("无效的部门编号");}
           // 完成后关闭
           rs.close();
           pst.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
  public void getSalary(Connection conn,int section_id){
      try {
          pst = conn.prepareStatement("SELECT max(salary) as max_salary,min(salary)as min_salary,avg(salary) as avg_salary FROM staffs where section_id=? group by section_id");
          pst.setInt(1,section_id);
          ResultSet rs = pst.executeQuery();
          // 展开结果集数据库
          if(rs.next()){
              // 通过字段检索
              int max_salary= rs.getInt("max_salary");
              int min_salary= rs.getInt("min_salary");
              int avg_salary= rs.getInt("avg_salary");
              // 输出数据
              System.out.println("max_salary\tmin_salary\tavg_salary");
              System.out.println( max_salary +"\t"+ min_salary+"\t" + avg_salary);
          }else {System.out.println("无效的部门编号");}
          // 完成后关闭
          rs.close();
          pst.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  public void getAll(Connection conn){
      try {
          pst = conn.prepareStatement("SELECT * FROM staffs order by salary DESC");
          ResultSet rs = pst.executeQuery();
          // 展开结果集数据库
          System.out.println("staff_id\tfirst_name\tlast_name\temail\tphone_number\thire_date\t" +
                  "employment_id\tsalary\tcommission_pct\tmanager_id\tsection_id\tgraduated_name");
          while(rs.next()){
              // 通过字段检索
              int staff_id  = rs.getInt("staff_id");
              String first_name = rs.getString("first_name");
              String last_name= rs.getString("last_name");
              String   email= rs.getString("email");
              String  phone_number=rs.getString("phone_number");
              String  hire_date = rs.getString("hire_date");
              String   employment_id = rs.getString("employment_id");
              int  salary  = rs.getInt("salary");
              int  commission_pct   = rs.getInt("commission_pct");
              int   manager_id   = rs.getInt("manager_id");
              int section_id   = rs.getInt("section_id");
              String    graduated_name = rs.getString("graduated_name");

              // 输出数据
              System.out.println( staff_id +"\t"+ first_name+"\t" + last_name+"\t" + email +"\t"+phone_number+"\t"
                      +hire_date+"\t" +  employment_id +"\t"+salary +"\t"+ commission_pct+"\t" + manager_id+"\t" + section_id +"\t"+ graduated_name);
          }
          // 完成后关闭
          rs.close();
          pst.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
    public void getAllSalary(Connection conn){
        try {
            pst = conn.prepareStatement("SELECT section_id, max(salary) as max_salary,min(salary)as min_salary,avg(salary) as avg_salary FROM staffs group by section_id order by section_id");
            ResultSet rs = pst.executeQuery();
            // 展开结果集数据库
            System.out.println("section_id\tmax_salary\tmin_salary\tavg_salary");
            while(rs.next()){
                // 通过字段检索
                int section_id=rs.getInt("section_id");
                int max_salary= rs.getInt("max_salary");
                int min_salary= rs.getInt("min_salary");
                int avg_salary= rs.getInt("avg_salary");
                // 输出数据
                System.out.println( section_id+"\t"+max_salary+"\t" + min_salary +"\t"+ avg_salary);
            }
            // 完成后关闭
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
