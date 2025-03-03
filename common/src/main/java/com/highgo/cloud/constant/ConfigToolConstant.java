/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.highgo.cloud.constant;

/**
 * hgadmin的常量
 * @author chushaolin
 *
 */
public class ConfigToolConstant {

    /**
     * 给hgadmin发请求时，URL拼接的数据库clusterId串
     */
    public static final String URL_ID_KEY = "?id=";
    /**
     * 给hgadmin发请求时，url地址
     */
    public static final String PGADMIN = "/pgadmin4";

    /**
     * 给hgadmin发请求时，hgadmin地址
     */
    public static final String HGADMIN = "/hgadmin/";
    /**
     * hgadmin登录用户必须是email格式的，所以，拼接上email property
     */
    public static final String HGADMIN_EMAIL_SUFFIX = "@highgo.com";

    /**
     * hgadmin 
     */
    public static final String HGADMIN_SERVERS = "servers";

    /**
     * 增加数据库的url
     */
    public static final String ADD_DB_URL = "addDbToAdmin";

    /**
     * 删除数据库的url
     */
    public static final String REMOVE_DB_URL = "delDbFromAdmin/";

    /**
     * 修改hgadmin登录用户密码的url
     */
    public static final String CHANGE_USER_PWD_URL = "changeHgadminPwd";

    /**
     * 是否已经添加到hgadmin
     * 0: 未添加
     * 1： 添加
     */
    public static final int IS_CONFIGED = 1;
}
