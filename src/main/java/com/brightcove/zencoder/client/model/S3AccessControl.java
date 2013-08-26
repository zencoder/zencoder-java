package com.brightcove.zencoder.client.model;

/**
 * @see https://app.zencoder.com/docs/api/encoding/s3-settings
 */
public class S3AccessControl {

    private String grantee;
    private S3PermissionType permission;

    public S3AccessControl() {
    }

    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public S3PermissionType getPermission() {
        return permission;
    }

    public void setPermission(S3PermissionType permission) {
        this.permission = permission;
    }

}
