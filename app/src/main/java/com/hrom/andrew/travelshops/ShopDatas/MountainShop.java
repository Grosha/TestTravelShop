package com.hrom.andrew.travelshops.ShopDatas;

import com.hrom.andrew.travelshops.R;

import java.util.ArrayList;
import java.util.List;

public class MountainShop extends SportShop {

    @Override
    public List<String> getListShops() {
        List<String> siteShops = new ArrayList<>();
        siteShops.add("Азімут");
        siteShops.add("Волоцюга");
        siteShops.add("Атлантида");
        siteShops.add("Ель-капітан");
        siteShops.add("Команда Екс");
        siteShops.add("X-zone");
        siteShops.add("Горгани");
        siteShops.add("Adrenalin");
        siteShops.add("Подорож");
        siteShops.add("Номад");
        siteShops.add("Ордана");
        siteShops.add("Skimarket");
        siteShops.add("Екстремалів нема");
        siteShops.add("Бізон");
        siteShops.add("Expert");
        siteShops.add("Мультіспорт");
        siteShops.add("Траверс");
        siteShops.add("Бескід");
        siteShops.add("Командор");
        siteShops.add("GoFree");
        siteShops.add("Драйв Спорт");
        return siteShops;
    }

    @Override
    public List<Integer> getIconShops() {
        List<Integer> imageShops = new ArrayList<>();
        imageShops.add(R.drawable.icon_azimut);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_atlantida);
        imageShops.add(R.drawable.icon_el_cap);
        imageShops.add(R.drawable.icon_ex);
        imageShops.add(R.drawable.icon_x_zone);
        imageShops.add(R.drawable.icon_gorgany);
        imageShops.add(R.drawable.icon_adrenalin);
        imageShops.add(R.drawable.icon_podoroj);
        imageShops.add(R.drawable.icon_nomad);
        imageShops.add(R.drawable.icon_ordana);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_extremalov);
        imageShops.add(R.drawable.icon_bizon);
        imageShops.add(R.drawable.icon_expert_centre);
        imageShops.add(R.drawable.icon_multisport);
        imageShops.add(R.drawable.icon_traverse);
        imageShops.add(R.drawable.icon_beskid);
        imageShops.add(R.drawable.icon_commandor);
        imageShops.add(R.drawable.icon_gofree);
        imageShops.add(R.drawable.icon_drive_sport);
        return imageShops;
    }

    @Override
    public String getLinkShop(int position) {
        ArrayList<String> listAdressWebSite = new ArrayList<>();
        listAdressWebSite.add("http://www.azimut.com.ua/");
        listAdressWebSite.add("http://volocuga.com/");
        listAdressWebSite.add("http://atlantida.net.ua/");
        listAdressWebSite.add("http://el-cap.kiev.ua/");
        listAdressWebSite.add("http://ex.com.ua/");
        listAdressWebSite.add("http://www.x-zone.com.ua/");
        listAdressWebSite.add("http://www.gorgany.com/");
        listAdressWebSite.add("http://www.adrenalin.kiev.ua/");
        listAdressWebSite.add("http://www.podoroj.com.ua/");
        listAdressWebSite.add("http://nomad.com.ua/");
        listAdressWebSite.add("http://ordana.com/");
        listAdressWebSite.add("http://skimarket.com.ua/");
        listAdressWebSite.add("http://www.extremalov.net/");
        listAdressWebSite.add("http://bizon.com.ua/");
        listAdressWebSite.add("http://www.expert-centre.com.ua/");
        listAdressWebSite.add("http://multisport.com.ua/");
        listAdressWebSite.add("http://traverse.com.ua/uk/");
        listAdressWebSite.add("http://beskid.com.ua/");
        listAdressWebSite.add("http://www.commandor.com.ua/");
        listAdressWebSite.add("http://www.gofree.com.ua/");
        listAdressWebSite.add("http://ru.drive-sport.com.ua/");
        return listAdressWebSite.get(position);
    }


}
