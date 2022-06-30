package employmentHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmploymentHistoryDao {
    PreparedStatement pst = null;
    public void getByStaffId(Connection conn,int staff_id){
        try {
            pst = conn.prepareStatement("SELECT * FROM employment_history where staff_id=?");
            pst.setInt(1,staff_id);
            ResultSet rs = pst.executeQuery();
                System.out.println("staff_id\temployment_id\tsection_id");
                while (rs.next()) {
                    // ͨ���ֶμ���
                    staff_id = rs.getInt("staff_id");
                    String employment_id = rs.getString("employment_id");
                    int section_id = rs.getInt("section_id");
                    // �������
                    System.out.println(staff_id + "\t" + employment_id + "\t" + section_id);
            }
            // ��ɺ�ر�
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
