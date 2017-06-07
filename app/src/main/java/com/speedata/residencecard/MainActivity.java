package com.speedata.residencecard;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

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
    private TextView tvMSg;
    private Button btnStart;
    ResidenceManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMSg = (TextView) findViewById(R.id.tv_msg);
        btnStart = (Button) findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                     manager = new ResidenceManager();
                    manager.initDevice(MainActivity.this);
                    IDInfor idInfor = manager.getEF01File();
                    showMSG(idInfor);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }




    private void showMSG(IDInfor idInfor) {
        if (idInfor != null) {
            if (idInfor.isSuccess()) {
                new AlertDialog.Builder(this).setTitle("居住证ef01文件信息").setMessage("姓名：" + idInfor.getName()
                        + "\n性别:" + idInfor.getSex() + "\n出生年月：" + idInfor.getBirthday() + "\n" +
                        "民族：" + idInfor.getNation() + "\n公民身份证号码：" + idInfor.getIdnum()
                        + "\n常用户口所在地：" + idInfor.getAddress() + "\n身高：" + idInfor.getHeight()
                        + "\n政治面貌:" + idInfor.getPolitics() + "\n" + "婚姻状况：" + idInfor.getMarriage_status()
                        + "\n文化程度：" + idInfor.getEducational_level() + "\n服兵役情况：" + idInfor.getArmy_service())
                        .setPositiveButton("确定", null).show();
            } else {
                new AlertDialog.Builder(this).setTitle("居住证信息").setMessage(idInfor.getErrorMsg())
                        .setPositiveButton("确定", null).show();
            }
        } else {
            new AlertDialog.Builder(this).setTitle("ERROR").setMessage("未获取到信息")
                    .setPositiveButton("确定", null).show();
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        if(manager!=null){
            manager.releaseDev();
        }
    }
    //    IPsam psam;
//    private IR6Manager mIR6Manager;
//
//
//    byte[] uuid = new byte[4];
//    byte[] random = new byte[8];
    /**
     * 测试流程
     */
//    private void TestFliow() throws IOException {
//        tvMSg.setText("");
//        int result = mIR6Manager.InitDevice();
////        tvMSg.setText("cpu result= " + result);
//        tvMSg.setVerticalScrollBarEnabled(true);
//        //cpu搜卡
//        byte[] data = mIR6Manager.SearchCard();
//        uuid = data;
//        tvMSg.append("\ncpu search rece>" + DataConversionUtils.byteArrayToStringLog(data, data.length));
//        //cpu读卡
//        data = mIR6Manager.ReadCard();
//        tvMSg.append("\ncpu_reset> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //cpu切换目录1
//        tvMSg.append("\ncpu dir send>" + DataConversionUtils.byteArrayToStringLog(cpu_dir, cpu_dir.length));
//        data = mIR6Manager.ExecCmdInput(cpu_dir);
//        tvMSg.append("\ncpu dir rece>" + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //cpu切换目录2
//        byte[] cmd = {0x00, (byte) 0xA4, 0x00, 0x00, 0x02, (byte) 0xDF, 0x01};
//        tvMSg.append("\ncpu dir send>" + DataConversionUtils.byteArrayToStringLog(cmd, cmd.length));
//        data = mIR6Manager.ExecCmdInput(cmd);
//        tvMSg.append("\ncpu dir rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //cpu切换目录3
//        //00A4000002EF01
//        byte[] cmd1 = {0x00, (byte) 0xA4, 0x00, 0x00, 0x02, (byte) 0xEF, 0x01};
//        data = mIR6Manager.ExecCmdInput(cmd1);
//        tvMSg.append("\ncpu dir rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //cpu 取随机数
//        data = mIR6Manager.ExecCmdInput(cpu_random);
//        if (data != null && data.length >= 10) {
//            System.arraycopy(data, 0, random, 0, 8);
//        } else {
//            tvMSg.append("\ncpu random error> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//            return;
//        }
//        tvMSg.append("\ncpu random rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//        if (data == null)
//            return;
////        tvMSg.append("\ncpu dir rece>" + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //psam卡初始化
//        data = psam.PsamPower(IPsam.PowerType.Psam1);
//        if (data == null) {
//            psam.resetDev();
//            SystemClock.sleep(200);
//            data = psam.PsamPower(IPsam.PowerType.Psam1);
//            if (data == null) {
//                tvMSg.append("\npower null");
//                return;
//            }
//        }
//        tvMSg.append("\n\nsend psam poweron rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //psam卡切换目录1
//        tvMSg.append("\npsam send dir " + DataConversionUtils.byteArrayToStringLog(psam_dir, psam_dir.length));
//        data = psam.WriteCmd(psam_dir, IPsam.PowerType.Psam1);
//        tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        //psam卡切换目录1
//        //00A40000021001
//        byte[] psam_dir2 = new byte[]{0x00, (byte) 0xA4, 0x00, 0x00, 0x02, 0x10, 0x01};
//        tvMSg.append("\npsam send dir " + DataConversionUtils.byteArrayToStringLog(psam_dir2, psam_dir2.length));
//        data = psam.WriteCmd(psam_dir2, IPsam.PowerType.Psam1);
//        tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//        data = psam.WriteCmd(psam_1, IPsam.PowerType.Psam1);
//        tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//
//        System.arraycopy(uuid, 0, psam_2, 11, 4);
//        tvMSg.append("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_2, psam_2.length));
//        data = psam.WriteCmd(psam_2, IPsam.PowerType.Psam1);
//        tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//
//        tvMSg.append("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_3, psam_3.length));
//        data = psam.WriteCmd(psam_3, IPsam.PowerType.Psam1);
//        tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//
//        System.arraycopy(random, 0, psam_4, 5, 8);
//        tvMSg.append("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_4, psam_4.length));
//        data = psam.WriteCmd(psam_4, IPsam.PowerType.Psam1);
//        if (data != null)
//            tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//
//        tvMSg.append("\npsam send> " + DataConversionUtils.byteArrayToStringLog(psam_5, psam_5.length));
//        data = psam.WriteCmd(psam_5, IPsam.PowerType.Psam1);
//        if (data != null)
//            tvMSg.append("\nrece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//        byte[] hdata = new byte[8];
//        byte[] ldata = new byte[8];
//        System.arraycopy(data, 0, hdata, 0, 8);
//        System.arraycopy(data, 8, ldata, 0, 8);
//        byte[] ExData8 = new byte[8];
//        for (int i = 0; i < 8; i++) {
//            ExData8[i] = (byte) (hdata[i] ^ ldata[i]);
//        }
//        tvMSg.append("\nhdata> " + DataConversionUtils.byteArrayToStringLog(hdata, hdata.length));
//        tvMSg.append("\nldata> " + DataConversionUtils.byteArrayToStringLog(ldata, ldata.length));
//
//
//        tvMSg.append("\nExData8> " + DataConversionUtils.byteArrayToStringLog(ExData8, ExData8.length));
//        //0082000108 + ExData8
//        byte[] cpu_renzheng = {0x00, (byte) 0x82, 0x00, 0x01, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
//        System.arraycopy(ExData8, 0, cpu_renzheng, 5, 8);
//
//        tvMSg.append("\ncpu send> " + DataConversionUtils.byteArrayToStringLog(cpu_renzheng, cpu_renzheng.length));
//        data = mIR6Manager.ExecCmdInput(cpu_renzheng);
//        if (data != null)
//            tvMSg.append("\nrenzheng rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//        else
//            tvMSg.append("read null");
//
//        byte[] readcmd = {0x00, (byte) 0xB0, 0x00, 0x00, (byte) 0xc8};
//        tvMSg.append("\ncpu send> " + DataConversionUtils.byteArrayToStringLog(readcmd, readcmd.length));
//        data = mIR6Manager.ExecCmdInput(readcmd);
//        if (data != null)
//            tvMSg.append("\nreadcard rece> " + DataConversionUtils.byteArrayToStringLog(data, data.length));
//        else
//            tvMSg.append("read null");
//        byte[] datal = mIR6Manager.ExecCmdInput(readcmd);
//        byte[] final_data = new byte[400];
//        System.arraycopy(data, 0, final_data, 0, 200);
//        System.arraycopy(datal, 0, final_data, 200, 200);
////        IDInfor idInfor = ParseIDInfor.parseIDInfor(final_data, false);
//        FileUtils.writeFileToSD(final_data);
//        ParseIdinfor parseIdinfor = new ParseIdinfor();
//        IDInfor idInfor = parseIdinfor.parseResidence(final_data);
//        System.out.print(idInfor.toString());
//        tvMSg.append("\ntest over\n\n\n\n" + idInfor.toString());
//        showMSG(idInfor);
//    }


}
