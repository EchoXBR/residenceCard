package com.speedata.residencecard;

import android.content.Context;
import android.os.SystemClock;

import com.speedata.libutils.DataConversionUtils;
import com.speedata.r6lib.IR6Manager;
import com.speedata.r6lib.R6Manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import speedatacom.a3310libs.PsamManager;
import speedatacom.a3310libs.inf.IPsam;

import static com.speedata.r6lib.R6Manager.CardType.CPUA;

/**
 * Created by echo on 2017/6/7.
 */

public class ResidenceManager {
    private IPsam psam;
    private IR6Manager mIR6Manager;

    private byte[] cpu_uuid = {(byte) 0x80, (byte) 0xe2, 0x00, 0x02, 0x04};
    //00A4000002DF01
    //00A4000002EF01
    byte[] cpu_dir = {0x00, (byte) 0xA4, 0x00, 0x00, 0x02, 0x3F, 0x00};
    byte[] cpu_random = {0x00, (byte) 0x84, 0x00, 0x00, 0x08};
    //00A40000023F00
    //  00A40000021001
    byte[] psam_dir = {0x00, (byte) 0xA4, 0x00, 0x00, 0x02, 0x3F, 0x00};
    //00 59 00 01 10 10 78 80 96 02 40 85 58 43 4F 53 10 11 26 49 80
    byte[] psam_1 = {0x00, 0x59, 0x00, 0x01, 0x10, 0x10, 0x78, (byte) 0x80, (byte) 0x96, 0x02, 0x40, (byte) 0x85, 0x58, 0x43, 0x4F, 0x53, 0x10, 0x11, 0x26, 0x49, (byte) 0x80};

    //00 57 00 00 10 85584D4F5340 + Uid4 + 000000000000
    byte[] psam_2 = {0x00, 0x57, 0x00, 0x00, 0x10, (byte) 0x85, 0x58, 0x4D, 0x4F, 0x53, 0x40, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};

    byte[] psam_3 = {0x00, 0x2A, 0x10, 0x0A, 0x00};
    //00 2B 00 00 10
    byte[] psam_4 = {0x00, 0x2B, 0x00, 0x00, 0x10, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
    byte[] psam_5 = {0x00, (byte) 0xC0, 0x00, 0x00, 0x10};

    public boolean initDevice(Context context) {
        psam = PsamManager.getPsamIntance();
        try {
            psam.initDev(context);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        SystemClock.sleep(1000);
        mIR6Manager = R6Manager.getInstance(CPUA);
        if (mIR6Manager == null)
            return false;
        return true;
    }

    byte[] uuid = new byte[4];
    byte[] random = new byte[8];

    /**
     * 获取基本信息
     *
     * @return IDInfor
     */
    public IDInfor getEF01File() throws UnsupportedEncodingException {
        IDInfor idInfor = new IDInfor();
        if (praseNULL(psam) && praseNULL(mIR6Manager)) {
            int result = mIR6Manager.InitDevice();
//        tvMSg.setText("cpu result= " + result);
            //cpu搜卡
            byte[] data = mIR6Manager.SearchCard();
            if (data == null) {
                idInfor.setErrorMsg("no card search");
                idInfor.setSuccess(false);
                return idInfor;
            }
            uuid = data;
            System.out.println("\ncpu search rece>" + DataConversionUtils.byteArrayToStringLog(data, data.length));
            //cpu读卡
            data = mIR6Manager.ReadCard();
            System.out.println("\ncpu_reset> " + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //cpu切换目录1
            System.out.println("\ncpu dir send>" + DataConversionUtils.byteArrayToStringLog(cpu_dir, cpu_dir.length));
            data = mIR6Manager.ExecCmdInput(cpu_dir);
            System.out.println("\ncpu dir rece>" + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //cpu切换目录2
            byte[] cmd = {0x00, (byte) 0xA4, 0x00, 0x00, 0x02, (byte) 0xDF, 0x01};
            System.out.println("\ncpu dir send>" + DataConversionUtils.byteArrayToStringLog(cmd, cmd.length));
            data = mIR6Manager.ExecCmdInput(cmd);
            System.out.println("\ncpu dir rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //cpu切换目录3
            //00A4000002EF01
            byte[] cmd1 = {0x00, (byte) 0xA4, 0x00, 0x00, 0x02, (byte) 0xEF, 0x01};
            data = mIR6Manager.ExecCmdInput(cmd1);
            System.out.println("\ncpu dir rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //cpu 取随机数
            data = mIR6Manager.ExecCmdInput(cpu_random);
            if (data != null && data.length >= 10) {
                System.arraycopy(data, 0, random, 0, 8);
            } else {
                System.out.println("\ncpu random error> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
                idInfor.setErrorMsg("cpu random error");
                idInfor.setSuccess(false);
                return idInfor;
            }
            System.out.println("\ncpu random rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
            if (data == null) {
                idInfor.setErrorMsg("cpu random get null");
                idInfor.setSuccess(false);
                return idInfor;
            }
//        System.out.println("\ncpu dir rece>" + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //psam卡初始化
            data = psam.PsamPower(IPsam.PowerType.Psam1);
            if (data == null) {
                psam.resetDev();
                SystemClock.sleep(200);
                data = psam.PsamPower(IPsam.PowerType.Psam1);
                if (data == null) {
                    System.out.println("\npower null");
                    idInfor.setErrorMsg("psam power null");
                    idInfor.setSuccess(false);
                    return idInfor;
                }
            }
            System.out.println("\n\nsend psam poweron rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //psam卡切换目录1
            System.out.println("\npsam send dir " + DataConversionUtils.byteArrayToStringLog(psam_dir, psam_dir.length));
            data = psam.WriteCmd(psam_dir, IPsam.PowerType.Psam1);
            System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));

            //psam卡切换目录1
            //00A40000021001
            byte[] psam_dir2 = new byte[]{0x00, (byte) 0xA4, 0x00, 0x00, 0x02, 0x10, 0x01};
            System.out.println("\npsam send dir " + DataConversionUtils.byteArrayToStringLog(psam_dir2, psam_dir2.length));
            data = psam.WriteCmd(psam_dir2, IPsam.PowerType.Psam1);
            System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
            data = psam.WriteCmd(psam_1, IPsam.PowerType.Psam1);
            System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));


            System.arraycopy(uuid, 0, psam_2, 11, 4);
            System.out.println("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_2, psam_2.length));
            data = psam.WriteCmd(psam_2, IPsam.PowerType.Psam1);
            System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));


            System.out.println("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_3, psam_3.length));
            data = psam.WriteCmd(psam_3, IPsam.PowerType.Psam1);
            System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));


            System.arraycopy(random, 0, psam_4, 5, 8);
            System.out.println("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_4, psam_4.length));
            data = psam.WriteCmd(psam_4, IPsam.PowerType.Psam1);
            if (data != null)
                System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));

            System.out.println("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_5, psam_5.length));
            data = psam.WriteCmd(psam_5, IPsam.PowerType.Psam1);
            if (data != null)
                System.out.println("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
            byte[] hdata = new byte[8];
            byte[] ldata = new byte[8];
            System.arraycopy(data, 0, hdata, 0, 8);
            System.arraycopy(data, 8, ldata, 0, 8);
            byte[] ExData8 = new byte[8];
            for (int i = 0; i < 8; i++) {
                ExData8[i] = (byte) (hdata[i] ^ ldata[i]);
            }
            System.out.println("\nhdata> " + DataConversionUtils.byteArrayToStringLog(hdata, hdata.length));
            System.out.println("\nldata> " + DataConversionUtils.byteArrayToStringLog(ldata, ldata.length));


            System.out.println("\nExData8> " + DataConversionUtils.byteArrayToStringLog(ExData8, ExData8.length));
            //0082000108 + ExData8
            byte[] cpu_renzheng = {0x00, (byte) 0x82, 0x00, 0x01, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
            System.arraycopy(ExData8, 0, cpu_renzheng, 5, 8);

            System.out.println("\ncpu send> " + DataConversionUtils.byteArrayToStringLog(cpu_renzheng, cpu_renzheng.length));
            data = mIR6Manager.ExecCmdInput(cpu_renzheng);
            if (data != null)
                System.out.println("\nrenzheng rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
            else
                System.out.println("read null");

            byte[] readcmd = {0x00, (byte) 0xB0, 0x00, 0x00, (byte) 0xc8};
            System.out.println("\ncpu send> " + DataConversionUtils.byteArrayToStringLog(readcmd, readcmd.length));
            data = mIR6Manager.ExecCmdInput(readcmd);
            if (data != null)
                System.out.println("\nreadcard rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
            else
                System.out.println("read null");
            byte[] datal = mIR6Manager.ExecCmdInput(readcmd);
            byte[] final_data = new byte[400];
            System.arraycopy(data, 0, final_data, 0, 200);
            System.arraycopy(datal, 0, final_data, 200, 200);
//        IDInfor idInfor = ParseIDInfor.parseIDInfor(final_data, false);
            FileUtils.writeFileToSD(final_data);
            ParseIdinfor parseIdinfor = new ParseIdinfor();
            idInfor = parseIdinfor.parseResidence(final_data);
        } else {
            idInfor.setSuccess(false);
            idInfor.setErrorMsg("未初始化");
        }
        return idInfor;
    }

    public boolean praseNULL(Object object) {
        if (object == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 释放设备相关操作句柄对象
     */
    public void releaseDev(){
        try {
            psam.releaseDev();
            mIR6Manager.ReleaseDevice();
            psam=null;
            mIR6Manager=null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
