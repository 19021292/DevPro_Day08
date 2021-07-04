package com.example.devpro_android43_day06;

public class SavePresenter {
    ISave isave;

    public SavePresenter(ISave isave) {
        this.isave = isave;
    }
    public void onSave(int d){
        if(d==1){
            isave.onSaveSuccessful("Successful save");
        }else{
            isave.onSaveError("Not save");
        }
    }
}
