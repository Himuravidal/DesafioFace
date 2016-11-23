package com.desafiolatam.desafioface.model;

import com.orm.SugarRecord;

/**
 * Created by cristian on 22-11-2016.
 */

public class BaseSugar extends SugarRecord {

    public long serverId;

    public long getServerId() {
        return serverId;
    }

    public void setServer_Id(long serverId) {
        this.serverId = serverId;
    }

    public void create(){
        setServer_Id(getId());
        setId(null);
        save();

    }


    @Override
    public long save() {
        return super.save();
    }
}
