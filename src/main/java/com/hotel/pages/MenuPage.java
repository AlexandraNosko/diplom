package com.hotel.pages;

import com.hotel.models.Room;
import com.hotel.models.Stage;
import com.hotel.repositories.StageRepository;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class MenuPage {

    @Inject
    private StageRepository stageRepository;

    private DefaultMenuModel menu;

    @PostConstruct
    public void init() {
        menu = new DefaultMenuModel();

        List<Stage> stages = stageRepository.findAll();
        for (Stage stage : stages) {
            DefaultSubMenu stageMenu = new DefaultSubMenu(stage.getNumber());
            menu.addElement(stageMenu);

            for (Room room : stage.getRooms()) {
                DefaultMenuItem itemRoom = new DefaultMenuItem(room.getId());
                stageMenu.addElement(itemRoom);
            }
        }
    }

    public StageRepository getStageRepository() {
        return stageRepository;
    }

    public void setStageRepository(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public DefaultMenuModel getMenu() {
        return menu;
    }

    public void setMenu(DefaultMenuModel menu) {
        this.menu = menu;
    }
}

