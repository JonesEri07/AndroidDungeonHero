package com.cre8ivec.ericj.dungeonhero.utility.Items;

public abstract class IItem {
    protected String name;
    protected Integer resource;
    protected String imgPath;

    public String getName() { return name; }
    public Integer getResource() { return resource; }
    public String getImgPath() { return imgPath; }
}
