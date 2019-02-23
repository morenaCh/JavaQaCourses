package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stq.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
        click(By.name("group_name"));
    }

    public void deleteSelectedGroups() {

        click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<>(); //tworzymy liste elementow typu GroupData
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));//tworzymy liste elementow /group,ktora zostanie pobrana ze strony ww
        for (WebElement element : elements) {
            String name = element.getText(); //dla kazdego elementu listy pobieramy text,
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //pobieramy indetyfikator kazdego elemntu, ktory jest unikatowy dla kazdego elementu//przeksztalcamy String w liczbe
            GroupData group = new GroupData(id, name, null, null); //tworzymy obiekt typu GroupData i pobieramy tylko name, gdyz tylko to jest nam znane
            groups.add(group);//dodajemy stworzony element do listy
        }
        return (groups);
    }

}
