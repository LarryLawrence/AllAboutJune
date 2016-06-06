/*
 * The data structure to store the item data.
 * @author DrunkPiano
 * @version 1.0
 * Modifying History:
 * Modifier: DrunkPiano, June 5th 2016, fixed to accord it with the standard coding disciplines.
 */

package com.drunkpiano.allaboutthejune;

public class ItemCellData {
    private String mTitle;
    private String mInfo;
    private String mHeaderText;
    private int mImageResourceId;

    public ItemCellData() {
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmInfo() {
        return mInfo;
    }

    public void setmInfo(String mInfo) {
        this.mInfo = mInfo;
    }

    public String getmHeaderText() {
        return mHeaderText;
    }

    public void setmHeaderText(String mHeaderText) {
        this.mHeaderText = mHeaderText;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
}
