package com.Nanask.school.config;

public class DBInfo {
	
	public static class student {
		
		public static final String st_num ="학번";
		public static final String st_name	="학생이름";
		public static final String st_tel	="전화번호";
		public static final String st_addr	="주소";
		public static final String st_grade	="학년";
		public static final String st_dpcode	="학과코드";
		public static final String st_dname	="학과명";
		public static final String st_dpro	="교과교수";
		
	}
	
	public static class dept {
		
		public static final String dp_code	="학과코드";
		public static final String dp_name	="학과명";
		public static final String dp_pro	="교과교수";
		
	}
	
	public static class score {
		
		public static final String sc_stnum	="학번";
		public static final String sc_sbname	="과목명";
		public static final String sc_score	="점수";

		
	}
	

}
