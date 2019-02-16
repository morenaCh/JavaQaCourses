package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stq.pft.addressbook.model.GroupData;

public class GroupHelper extends BaseHelper {
    
    public GroupHelper(WebDriver wd) {

        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"),groupData.getHeader());
        type(By.name("group_footer"),groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
        click(By.name("group_name"));
    }

    public void deleteSelectedGroups() {

        click(By.name("delete"));
    }

    public void selectGroup() {

        click(By.name("selected[]"));
    }


    public void initGroupModification() {
        click(By.xpath("//input[3]"));
    }

    public void submitGroupModification() {
        click(By.cssSelector("input[type='submit']"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAgroup() {
        return isElementPresent(By.name("selected[]"));
    }
}
