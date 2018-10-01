package com.hotel.pages;

import com.hotel.models.Stage;
import com.hotel.repositories.StageRepository;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class MenuPage {

    @Inject
    private StageRepository stageRepository;

    public MenuModel getStageList() {
        List<Stage> stages = stageRepository.findAll();
        StageMenu stageMenu = new StageMenu(stages);

        return stageMenu;
    }

   /* public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }*/
}

class StageMenu implements MenuModel {

    List<MenuElement> elements;

    public StageMenu(List<Stage> stages) {
        elements = new ArrayList<>();
        for (Stage stage : stages) {
            DefaultMenuItem menuItem = new DefaultMenuItem(stage.getNumber());
            elements.add(menuItem);
        }
    }

    @Override
    public List<MenuElement> getElements() {
        return elements;
    }

    @Override
    public void addElement(MenuElement menuElement) {

    }

    @Override
    public void generateUniqueIds() {

    }
}

