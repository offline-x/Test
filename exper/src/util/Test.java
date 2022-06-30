package util;

import Place.PlaceDao;
import Sections.SectionsDao;
import Staffs.StaffsDao;
import employmentHistory.EmploymentHistoryDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection conn=getCon.getConnection();
        StaffsDao staffsDao=new StaffsDao();
        SectionsDao sectionsDao=new SectionsDao();
        PlaceDao placeDao=new PlaceDao();
        EmploymentHistoryDao employmentHistoryDao=new EmploymentHistoryDao();
        System.out.println("---------------------------------功能表------------------------------\n" +
                "1:输入staff_id，查看该员工基本信息；\n" +
                "2:按员工姓名查询员工基本信息；\n" +
                "3:输入staff_id，修改该员工的电话号码；\n" +
                "4:输入section_id，可以查看该部门所有员工基本信息（按员工编号升序排列）；\n" +
                "5:输入section_id，可以统计查询该部门员工最高工资，最低工资以及平均工资；\n" +
                "6:查看所有员工基本信息（按工资降序排列）；\n" +
                "7:可以统计各部门员工最高工资，最低工资以及平均工资；\n" +
                "8.1:可以查询各部门基本信息，\n" +
                "8.2:并可以根据部门编号修改部门名称；\n" +
                "9.1:可以查询各工作地点基本信息，\n" +
                "9.2:并可以增加新的工作地点；\n" +
                "10:可以按员工编号查询员工工作信息，包括其历史工作信息，返回员工编号，职位编号和部门编号；\n"+
                "exit:退出程序\n" +
                "------------------------------------------------------------------------");
        String s=null;
        boolean b=true;
        while (b){
            System.out.println("请输入功能编号：");
            s=sc.next();
         switch (s) {
            case "1":
                System.out.println("请输入员工编号：");
                int staff_id1=sc.nextInt();
                staffsDao.getStaffsById(conn,staff_id1);
                break;
            case "2":
                System.out.println("请输入员工first_name：");
                String f=sc.next();
                System.out.println("请输入员工last_name：");
                String l=sc.next();
                staffsDao.getStaffByname(conn,f,l);
                break;
            case "3":
                System.out.println("请输入员工编号：");
                int staff_id2=sc.nextInt();
                System.out.println("请输入新的电话号码：");
                String p=sc.next();
                staffsDao.modify(conn,staff_id2,p);
                break;
            case "4":
                System.out.println("请输入部门编号：");
                int section_id1=sc.nextInt();
                staffsDao.getBysectionId(conn,section_id1);
                break;
            case "5":
                System.out.println("请输入部门编号：");
                int section_id2=sc.nextInt();
                staffsDao.getSalary(conn,section_id2);
                break;
            case "6":
                System.out.println("查看所有员工基本信息");
                staffsDao.getAll(conn);
                break;
            case "7":
                System.out.println("查看所有部门最高工资、最低工资、平均工资");
                staffsDao.getAllSalary(conn);
                break;
            case "8.1":
                System.out.println("查看所有部门基本信息");
                sectionsDao.getAll(conn);
                break;
            case "8.2":
                System.out.println("请输入部门编号：");
                int section_id3=sc.nextInt();
                System.out.println("请输入新的部门名称：");
                String name=sc.next();
                sectionsDao.modify(conn,section_id3,name);
                break;
            case "9.1":
                System.out.println("查看各工作地点基本信息");
                placeDao.getAll(conn);
                break;
             case "9.2":
                 System.out.println("请输入新工作点的部门位置编号:");
                 int place_id=sc.nextInt();
                 System.out.println("请输入新工作点的街道位置：");
                 String sa=sc.next();
                 System.out.println("请输入新工作点的邮编：");
                 String pc=sc.next();
                 System.out.println("请输入新工作点的城市：");
                 String city= sc.next();
                 System.out.println("请输入新工作点的省份名字：");
                 String sp=sc.next();
                 System.out.println("请输入新工作点的省份编号：");
                 String si=sc.next();
                 placeDao.add(conn,place_id,sa,pc,city,sp,si);
                 break;
            case "10":
                System.out.println("请输入员工编号：");
                int staff_id3=sc.nextInt();
                employmentHistoryDao.getByStaffId(conn,staff_id3);
                break;
            case "exit":
                b=false;
                break;
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
