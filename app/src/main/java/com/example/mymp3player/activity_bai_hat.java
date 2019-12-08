package com.example.mymp3player;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class activity_bai_hat extends AppCompatActivity {

    TextView txt_tencasi, txt_tenbaihatdangphat, txt_tgdangphat, txt_tgketthuc;
    ImageButton IMGB_play, IMGB_next, IMGB_back,IMGB_foward,IMGB_rewind;
    ListView listView_baihat;
    SeekBar seekBar;

    int vitri;

    ArrayList<list_baihat> list_baihats;

    MediaPlayer player = new MediaPlayer();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);

        Intent intent = getIntent();
        int vt = intent.getIntExtra("position", 0);
        String cs = intent.getStringExtra("tencasi");

        txt_tencasi = (TextView) findViewById(R.id.txt_casi);
        txt_tenbaihatdangphat = (TextView) findViewById(R.id.txt_dang_phat);
        txt_tgdangphat = (TextView) findViewById(R.id.txt_time_play);
        txt_tgketthuc = (TextView) findViewById(R.id.txt_time_out);
        IMGB_next = (ImageButton) findViewById(R.id.bt_next);
        IMGB_play = (ImageButton) findViewById(R.id.bt_pause);
        IMGB_back = (ImageButton) findViewById(R.id.bt_back);
        IMGB_foward=(ImageButton) findViewById(R.id.bt_forward);
        IMGB_rewind=(ImageButton) findViewById(R.id.bt_rewind);
        listView_baihat = (ListView) findViewById(R.id.list_nhac);
        seekBar = (SeekBar) findViewById(R.id.seebar);

        txt_tencasi.setText("Ca sĩ: " + cs);

        list_baihats = new ArrayList<list_baihat>();

        switch (vt){
            case 0:
                list_baihats.add(new list_baihat("Làm vợ anh nhé",time(R.raw.chidan_lam_vo_anh_nhe),R.raw.chidan_lam_vo_anh_nhe));
                list_baihats.add(new list_baihat("Sự thật sau một lời hứa",time(R.raw.chidan_su_that_sau_mot_loi_hua),R.raw.chidan_su_that_sau_mot_loi_hua));
                break;
            case 1:
                list_baihats.add(new list_baihat("Bức tranh từ nước mắt",time(R.raw.siro_buc_tranh_tu_nuoc_mat),R.raw.siro_buc_tranh_tu_nuoc_mat));
                list_baihats.add(new list_baihat("Chỉ có một người để yêu trên thế gian",  time(R.raw.siro_chi_co_mot_nguoi_de_yeu_tren_the_gian), R.raw.siro_chi_co_mot_nguoi_de_yeu_tren_the_gian)   );
                list_baihats.add(new list_baihat("Dây dức nổi đau",time(R.raw.siro_day_duc_noi_dau),R.raw.siro_day_duc_noi_dau));
                list_baihats.add(new list_baihat("Dưới những cơn mưa",time(R.raw.siro_duoi_nhung_con_mua), R.raw.siro_duoi_nhung_con_mua) );
                list_baihats.add(new list_baihat("Giấc mơ củ anh",time(R.raw.siro_giac_mo_cua_anh),R.raw.siro_giac_mo_cua_anh));
                break;
            case 2:
                list_baihats.add(new list_baihat("Bí mật của hạnh phúc",time(R.raw.ngokienhuy_bi_mat_cua_hanh_phuc),R.raw.ngokienhuy_bi_mat_cua_hanh_phuc));
                list_baihats.add(new list_baihat("Chúc em ngủ ngon", time(R.raw.ngokienhuy_chuc_em_ngu_ngon),R.raw.ngokienhuy_chuc_em_ngu_ngon)   );
                break;
            case 3:
                list_baihats.add(new list_baihat("Đấp mộ cuộc tình", time(R.raw.dannguyen_dap_mo_cuoc_tinh), R.raw.dannguyen_dap_mo_cuoc_tinh) );
                list_baihats.add(new list_baihat("Lại nhớ người yêu",time(R.raw.dannguyen_lai_nho_nguoi_yeu), R.raw.dannguyen_lai_nho_nguoi_yeu)  );
                break;
            case 4:
                list_baihats.add(new list_baihat("Chuyện hẹn hò", time(R.raw.quangle_chuyen_hen_ho), R.raw.quangle_chuyen_hen_ho)  );
                list_baihats.add(new list_baihat("Chuyện tình không dĩ vãng", time(R.raw.quangle_chuyen_tinh_khong_di_vang),R.raw.quangle_chuyen_tinh_khong_di_vang)            );
                list_baihats.add(new list_baihat("Đập vỡ cây đàn",time(R.raw.quangle_dap_vo_cay_dan), R.raw.quangle_dap_vo_cay_dan));
                list_baihats.add(new list_baihat("Đôi mắt người xưa",time(R.raw.quangle_doi_mat_nguoi_xua), R.raw.quangle_doi_mat_nguoi_xua) );
                break;
            case 5:
                list_baihats.add(new list_baihat("Đám cưới nghèo", time(R.raw.truongvu_dam_cuoi_ngheo),  R.raw.truongvu_dam_cuoi_ngheo));
                list_baihats.add(new list_baihat("Giết người anh yêu", time(R.raw.truongvu_giet_nguoi_anh_yeu),  R.raw.truongvu_giet_nguoi_anh_yeu));
                list_baihats.add(new list_baihat("Hai kỹ niệm một chuyến đi", time(R.raw.truongvu_hai_ky_niem_mot_chuyen_di),  R.raw.truongvu_hai_ky_niem_mot_chuyen_di));
                list_baihats.add(new list_baihat("Không còn nhớ người yêu", time(R.raw.truongvu_khong_con_nho_nguoi_yeu), R.raw.truongvu_khong_con_nho_nguoi_yeu));
                list_baihats.add(new list_baihat("Túy ca",time(R.raw.truongvu_tuy_ca),  R.raw.truongvu_tuy_ca));
                break;
            case 6:
                list_baihats.add(new list_baihat("Anh nhớ em người yêu cũ", time(R.raw.minhvuong_m4u_anh_nho_em_nguoi_yeu_cu_cua),  R.raw.minhvuong_m4u_anh_nho_em_nguoi_yeu_cu_cua) );
                list_baihats.add(new list_baihat("Anh vẫn còn yêu em", time(R.raw.minhvuong_m4u_anh_van_con_yeu_em),  R.raw.minhvuong_m4u_anh_van_con_yeu_em));
                list_baihats.add(new list_baihat("Chờ định mệnh mĩm cười", time(R.raw.minhvuong_m4u_cho_dinh_menh_mim_cuoi), R.raw.minhvuong_m4u_cho_dinh_menh_mim_cuoi));
                list_baihats.add(new list_baihat("Đừng làm anh đau", time(R.raw.minhvuong_m4u_dung_lam_anh_dau), R.raw.minhvuong_m4u_dung_lam_anh_dau));
                list_baihats.add(new list_baihat("Nỗi đau xót xa",time(R.raw.minhvuong_m4u_noi_dau_xot_xa),R.raw.minhvuong_m4u_noi_dau_xot_xa));
                break;
        }

        Adapter_listbaihat adapter_listbaihat = new Adapter_listbaihat(activity_bai_hat.this, R.layout.list_bai_hat, list_baihats);
        listView_baihat.setAdapter(adapter_listbaihat);
        khoitao();
        player.start();
        IMGB_play.setImageResource(R.drawable.pause);
        thoigian_hientai();
        listView_baihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (player.isPlaying()) {
                    player.stop();
                }
                else {
                    vitri = position;
                    khoitao();
                }
                IMGB_play.setImageResource(R.drawable.pause);
            }
        });

        IMGB_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying()) {
                    player.pause();
                    IMGB_play.setImageResource(R.drawable.play);
                }
                else {
                    player.start();
                    IMGB_play.setImageResource(R.drawable.pause);
                }
            }
        });
        IMGB_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vitri++;
                if (vitri > (list_baihats.size() -1)) {
                    vitri = 0;
                }
                player.stop();
                khoitao();
            }
        });

        IMGB_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vitri--;
                if (vitri < 0) {
                    vitri = list_baihats.size()-1;
                }
                player.stop();
                khoitao();
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.seekTo(seekBar.getProgress());
            }
        });
    }

    void thoigian_hientai() {
        final Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                txt_tgdangphat.setText(simpleDateFormat.format(player.getCurrentPosition()));
                seekBar.setProgress(player.getCurrentPosition());
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        vitri++;
                        if (vitri > list_baihats.size() - 1) {
                            vitri = 0;
                            player.stop();
                            IMGB_play.setImageResource(R.drawable.play);
                        }
                        else {
                            player.stop();
                            khoitao();
                            player.start();
                        }
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);

    }

    private void khoitao() {
        player = MediaPlayer.create(activity_bai_hat.this, list_baihats.get(vitri).bathat);
        txt_tenbaihatdangphat.setText("Đang phát: " + list_baihats.get(vitri).tenbaihat);
        txt_tgketthuc.setText(time(list_baihats.get(vitri).bathat));
        seekBar.setMax(player.getDuration());
        player.start();
    }

    private  String time(int baihat) {
        String t;
        MediaPlayer player = new MediaPlayer();
        player = MediaPlayer.create(activity_bai_hat.this, baihat);
        SimpleDateFormat tg = new SimpleDateFormat("mm:ss");
        t = tg.format(player.getDuration());
        return t;
    }

    @Override
    protected void onStop() {
        player.stop();
        super.onStop();
    }
}
