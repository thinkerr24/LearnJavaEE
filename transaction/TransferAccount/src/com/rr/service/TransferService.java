package com.rr.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.rr.dao.TransferDao;
import com.rr.utils.C3P0Utils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		
		TransferDao dao = new TransferDao();
		//Connection conn = null;
		try {
			/* ��
			// ��ȡ����
			conn = C3P0Utils.getConnection();
			// ��������
			conn.setAutoCommit(false);
			
			*/
			/* �� */
			// ��������
			C3P0Utils.startTransaction();
			// ת��Ǯ����
			dao.out(out, money);
			// *��������*
		   // int i = 1 / 0;
			// ת��Ǯ����
			dao.in(in, money);
		} catch (Exception e) {
			// �¼��ع�
			try {
				C3P0Utils.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			try {
				C3P0Utils.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}
