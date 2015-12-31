package com.greentech.agusedyc.itc;

/**
 * Created by agusedyc on 17/12/15.
 */
public class Config {
    //Address of our scripts of the CRUD

    /*public static final String URL_ADD="http://prjk.esy.es/restEmp/addEmp.php";
    public static final String URL_GET_ALL = "http://prjk.esy.es/restEmp/getAllEmp.php";
    public static final String URL_GET_EMP = "http://prjk.esy.es/restEmp/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://prjk.esy.es/restEmp/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://prjk.esy.es/restEmp/deleteEmp.php?id=";*/

    public static final String URL_ADD="http://prjk.esy.es/restMember/addMbr.php";
    public static final String URL_GET_ALL = "http://prjk.esy.es/restMember/getAllMbr.php";
    public static final String URL_GET_MBR = "http://prjk.esy.es/restMember/getMbr.php?id=";
    public static final String URL_UPDATE_MBR = "http://prjk.esy.es/restMember/updateMbr.php";
    public static final String URL_DELETE_MBR = "http://prjk.esy.es/restMember/deleteMbr.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_MBR_ID = "id";
    public static final String KEY_MBR_NAMA = "nama";
    public static final String KEY_MBR_ALAMAT = "alamat";
    public static final String KEY_MBR_NOHP = "nohp";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_NOHP = "nohp";

    //member id to pass with intent
    public static final String MBR_ID = "mbr_id";
}
