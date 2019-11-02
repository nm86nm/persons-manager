package com.mnp.personsmanager;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class PersonGui extends VerticalLayout {
    private Button buttonAdd;
    private Button buttonDelete;
    private PersonDao personDao;
    private TextField textFieldId;
    private TextField textFieldFirstname;
    private TextField textFieldLastname;

    @Autowired
    public PersonGui(PersonDao personDao) {
        this.personDao = personDao;
        this.textFieldId = new TextField("Id");
        this.textFieldFirstname = new TextField("Firstname");
        this.textFieldLastname = new TextField("Lastname");
        this.buttonAdd = new Button("Add");
        this.buttonDelete = new Button("Delete");

        buttonAdd.addClickListener(buttonClickEvent -> {
            personDao.add(new Person(Long.parseLong(textFieldId.getValue()), textFieldFirstname.getValue(), textFieldLastname.getValue()));
        });

        buttonDelete.addClickListener(buttonClickEvent -> {
            personDao.delete(Long.parseLong(textFieldId.getValue()));
        });

        add(textFieldId, textFieldFirstname, textFieldLastname, buttonAdd, buttonDelete);
    }
}