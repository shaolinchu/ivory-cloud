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

package com.highgo.platform.apiserver.model.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author srk
 */
@Entity
@Data
@Table(name = "config_param_defination")
public class ConfigParamDefinationPO extends BaseEntity {

    /**
     * 参数名称
     */
    private String name;
    /**
     * 参数类型 枚举、数字、字符串...
     */
    private String paramType;
    /**
     * 默认值
     */
    private String defaultValue;
    /**
     * 最小值
     */
    private String min;
    /**
     * 最大值
     */
    private String max;
    /**
     * 枚举值
     */
    private String enumValue;
    /**
     * 规则
     */
    private String rule;
    /**
     * 描述
     */
    private String description;

}
