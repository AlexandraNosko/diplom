package com.hotel.pages;

import com.hotel.models.Stage;
import com.hotel.repositories.StageRepository;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AddStagePage {

    @Inject
    private StageRepository stageRepository;

    @Inject
    private MenuPage menuPage;

    private String stageNumber;

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(String stageNumber) {
        this.stageNumber = stageNumber;
    }

    public StageRepository getStageRepository() {
        return stageRepository;
    }

    public void setStageRepository(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }


    public String addStage() {
        if (stageNumber != null && stageNumber.equals("")) {
            sendMessage("Введите номер этажа");
            return null;
        }
        Stage stage = new Stage();
        stage.setNumber(stageNumber);
        stageRepository.save(stage);
        sendMessage("Этаж успешно сохранен");
        menuPage.init();
        return "goToMenu";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}
