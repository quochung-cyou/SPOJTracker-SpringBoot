package com.quochungcyou.spring_spoj.APiUtils;

import com.google.gson.Gson;
import com.quochungcyou.spring_spoj.Models.Player;
import jakarta.annotation.PostConstruct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@Async
@EnableAsync
public class JsoupHelper {
    List<Player> players = new ArrayList<>();
    public JsoupHelper() {
        addPlayer();
    }

    public List<Player> getData() {
        System.out.println("Crawling data... " + players.size());
        for (int i = 0; i < players.size(); i++) {
            String username = players.get(i).getUsername();
            FileReader fileReader;
            try {
                fileReader = new FileReader("src/main/resources/static/" + username + ".json", StandardCharsets.UTF_8);
                Gson gson = new Gson();
                Player player = gson.fromJson(fileReader, Player.class);
                players.set(i, player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        players.sort((o1, o2) -> o2.getScore() - o1.getScore());
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setRank(i + 1);
        }
        return players;
    }


    @PostConstruct
    //cron every 10 sec
    @Scheduled(fixedDelay = 10000)
    public void crawlData() {
        //Multi thread
        System.out.println("Auto Crawling data... " + players.size());
        new Thread(this::threadCrawlData).start();
    }

    public void threadCrawlData() {

        try {
            for (Player player : players) {
                String username = player.getUsername();

                String url = "https://www.spoj.com/PTIT/users/" + username + "/";
                int count = 0;
                Document data = Jsoup.connect(url).get();
                String avatarurl = data.select(".img-thumbnail").attr("src");
                Elements list = data.select("td > a");
                //Log.d("DEBUG1", String.valueOf(list1.size()) + " " + avatarurl);
                for (Element link : list) {
                    //Log.d("DEBUG1", link.attr("href"));
                    if (link.attr("href").contains(username) && link.attr("href").contains("/PTIT/status/")) {
                        int index1 = String.valueOf(link).indexOf("/PTIT/status/");
                        int index2 = String.valueOf(link).indexOf(username);
                        if (String.valueOf(link).substring(index1, index2).length() > 14) {
                            count++;
                        }
                    }
                }
                try {
                    //create file if not have
                    File file = new File("src/main/resources/static/" + username + ".json");
                    file.getParentFile().mkdirs();
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter("src/main/resources/static/" + username + ".json", StandardCharsets.UTF_8);
                    player.setScore(count);
                    player.setUrlimage(avatarurl);
                    fileWriter.write(new Gson().toJson(player));
                    fileWriter.close();
                    //System.out.println("Done write " + player.getName() + " " + player.getScore());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void addPlayer() {
        //constructor String name, String username, Integer score, Integer rank, Integer target
        players.add(new Player(1, "Lê Hương Giang", "gxdumpling", 0, 250));
        players.add(new Player(2, "Nguyễn Thị Như Quỳnh", "milomoli5104", 0, 400));
        players.add(new Player(3, "Đỗ Lý Minh Anh", "minhengdey", 0, 350));
        players.add(new Player(4, "Lê Hải Đăng", "mr_phoenix", 0, 500));
        players.add(new Player(5, "Bùi Thế Vĩnh Nguyên", "nguyenbui256", 0, 450));
        players.add(new Player(6, "Phạm Quang Minh", "minh_pro544", 0, 450));
        players.add(new Player(7, "Đoàn Thảo Vân", "doan_van_411", 0, 300));
        players.add(new Player(8, "Phan Thanh Tân", "tanatana", 0, 416));
        players.add(new Player(9, "Hoàng Trung Hiếu", "jinjja", 0, 400));
        players.add(new Player(10, "Phan Văn Duy", "phanduy156", 0, 350));
        players.add(new Player(11, "Trần Xuân Sơn", "n1_transon", 0, 400));
        players.add(new Player(12, "Lê Đình Hiệp", "lehiep2004", 0,400));
        players.add(new Player(13, "Phan Thị Hồng Thắm", "thm1911", 0, 300));
        players.add(new Player(14, "Hoàng Hải Long", "hoanghailong", 0, 400));
        players.add(new Player(15, "Mộc Thu Huyền", "comneyuh", 0, 250));
        players.add(new Player(16, "Nguyễn Hoa Thanh Tùng", "not_thtung302", 0,350));
        players.add(new Player(17, "Nguyễn Bá Việt Hoàng", "prestigeporo", 0, 333));
        players.add(new Player(18, "Bùi Thái Sỹ", "bitis_2004", 0, 450));
        players.add(new Player(19, "Đặng Huyền Trang", "dh_trang", 0, 350));
        players.add(new Player(20, "Bùi Quang Đạt", "dat_oc_zz1710", 0, 350));
        players.add(new Player(21, "Vũ Mạnh Hùng", "vuhuq_25133", 0, 300));
        players.add(new Player(22, "Nguyễn Hữu Tiến", "tien_chicken01", 0, 400));
        players.add(new Player(23, "Lê Tuấn Ngọc", "tuanngoc_0_0", 0, 400));
        players.add(new Player(24, "Trần Đức Chính", "ducchinh04", 0, 450));
        players.add(new Player(25, "Trần Tiểu Long", "longdragon02", 0, 372));
        players.add(new Player(26, "Nguyễn Nhật Thành", "divinera1", 0, 500));
        players.add(new Player(27, "Nguyễn Thành Công", "d22cn090", 0, 550));
    }
}
