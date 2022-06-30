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
        System.out.println("---------------------------------���ܱ�------------------------------\n" +
                "1:����staff_id���鿴��Ա��������Ϣ��\n" +
                "2:��Ա��������ѯԱ��������Ϣ��\n" +
                "3:����staff_id���޸ĸ�Ա���ĵ绰���룻\n" +
                "4:����section_id�����Բ鿴�ò�������Ա��������Ϣ����Ա������������У���\n" +
                "5:����section_id������ͳ�Ʋ�ѯ�ò���Ա����߹��ʣ���͹����Լ�ƽ�����ʣ�\n" +
                "6:�鿴����Ա��������Ϣ�������ʽ������У���\n" +
                "7:����ͳ�Ƹ�����Ա����߹��ʣ���͹����Լ�ƽ�����ʣ�\n" +
                "8.1:���Բ�ѯ�����Ż�����Ϣ��\n" +
                "8.2:�����Ը��ݲ��ű���޸Ĳ������ƣ�\n" +
                "9.1:���Բ�ѯ�������ص������Ϣ��\n" +
                "9.2:�����������µĹ����ص㣻\n" +
                "10:���԰�Ա����Ų�ѯԱ��������Ϣ����������ʷ������Ϣ������Ա����ţ�ְλ��źͲ��ű�ţ�\n"+
                "exit:�˳�����\n" +
                "------------------------------------------------------------------------");
        String s=null;
        boolean b=true;
        while (b){
            System.out.println("�����빦�ܱ�ţ�");
            s=sc.next();
         switch (s) {
            case "1":
                System.out.println("������Ա����ţ�");
                int staff_id1=sc.nextInt();
                staffsDao.getStaffsById(conn,staff_id1);
                break;
            case "2":
                System.out.println("������Ա��first_name��");
                String f=sc.next();
                System.out.println("������Ա��last_name��");
                String l=sc.next();
                staffsDao.getStaffByname(conn,f,l);
                break;
            case "3":
                System.out.println("������Ա����ţ�");
                int staff_id2=sc.nextInt();
                System.out.println("�������µĵ绰���룺");
                String p=sc.next();
                staffsDao.modify(conn,staff_id2,p);
                break;
            case "4":
                System.out.println("�����벿�ű�ţ�");
                int section_id1=sc.nextInt();
                staffsDao.getBysectionId(conn,section_id1);
                break;
            case "5":
                System.out.println("�����벿�ű�ţ�");
                int section_id2=sc.nextInt();
                staffsDao.getSalary(conn,section_id2);
                break;
            case "6":
                System.out.println("�鿴����Ա��������Ϣ");
                staffsDao.getAll(conn);
                break;
            case "7":
                System.out.println("�鿴���в�����߹��ʡ���͹��ʡ�ƽ������");
                staffsDao.getAllSalary(conn);
                break;
            case "8.1":
                System.out.println("�鿴���в��Ż�����Ϣ");
                sectionsDao.getAll(conn);
                break;
            case "8.2":
                System.out.println("�����벿�ű�ţ�");
                int section_id3=sc.nextInt();
                System.out.println("�������µĲ������ƣ�");
                String name=sc.next();
                sectionsDao.modify(conn,section_id3,name);
                break;
            case "9.1":
                System.out.println("�鿴�������ص������Ϣ");
                placeDao.getAll(conn);
                break;
             case "9.2":
                 System.out.println("�������¹�����Ĳ���λ�ñ��:");
                 int place_id=sc.nextInt();
                 System.out.println("�������¹�����Ľֵ�λ�ã�");
                 String sa=sc.next();
                 System.out.println("�������¹�������ʱࣺ");
                 String pc=sc.next();
                 System.out.println("�������¹�����ĳ��У�");
                 String city= sc.next();
                 System.out.println("�������¹������ʡ�����֣�");
                 String sp=sc.next();
                 System.out.println("�������¹������ʡ�ݱ�ţ�");
                 String si=sc.next();
                 placeDao.add(conn,place_id,sa,pc,city,sp,si);
                 break;
            case "10":
                System.out.println("������Ա����ţ�");
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
