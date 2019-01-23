package com.cdgit.loan.csm.po;

public class CsmPubConfigPoKey {
	
    private String cfgGroup;

    private String cfgKey;

    public String getCfgGroup() {
        return cfgGroup;
    }

    public void setCfgGroup(String cfgGroup) {
        this.cfgGroup = cfgGroup == null ? null : cfgGroup.trim();
    }

    public String getCfgKey() {
        return cfgKey;
    }

    public void setCfgKey(String cfgKey) {
        this.cfgKey = cfgKey == null ? null : cfgKey.trim();
    }

}
