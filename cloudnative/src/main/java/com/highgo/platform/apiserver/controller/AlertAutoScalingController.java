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

package com.highgo.platform.apiserver.controller;

import com.highgo.platform.apiserver.model.vo.request.AlertMessage;
import com.highgo.platform.apiserver.model.vo.request.ModifyAlertRuleVO;
import com.highgo.platform.apiserver.model.vo.request.ModifySwitchVO;
import com.highgo.platform.apiserver.model.vo.response.ActionResponse;
import com.highgo.platform.apiserver.model.vo.response.AutoScalingAlertRuleVO;
import com.highgo.platform.apiserver.model.vo.response.AutoScalingSwitchVO;
import com.highgo.platform.apiserver.service.AlertAutoScalingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: highgo-lucunqiao
 * @date: 2023/3/27 15:55
 * @Description: alert
 */
@RestController
@RequestMapping("${common.alert-path-prefix}")
@Slf4j
public class AlertAutoScalingController {

    @Resource
    private AlertAutoScalingService alertAutoScalingService;

    @RequestMapping(value = "/autoscaling", method = RequestMethod.POST)
    public void autoScaling(@RequestBody AlertMessage message) {
        String autoscaling = message.getCommonLabels().getAutoscaling();
        if (StringUtils.isEmpty(autoscaling)) {
            // 不是自动伸缩的告警，不处理
            log.warn("Not processed,not autoscaling alert message:{}", message);
            return;
        }
        alertAutoScalingService.alertAutoScaling(message);
    }

    @RequestMapping(value = "/autoscaling/{userId}/{clusterId}", method = RequestMethod.GET)
    public AutoScalingSwitchVO getAutoscalingSwitch(@Validated @PathVariable String userId,
            @Validated @PathVariable String clusterId) {
        return alertAutoScalingService.getAutoScalingSwitch(userId, clusterId);
    }

    @RequestMapping(value = "/autoscaling/{userId}/{clusterId}/action", method = RequestMethod.POST)
    public ActionResponse autoscalingSwitch(@Validated @PathVariable String userId,
            @Validated @PathVariable String clusterId, @RequestBody ModifySwitchVO modifySwitchVO) {
        return alertAutoScalingService.autoscalingSwitch(userId, clusterId, modifySwitchVO);
    }

    @RequestMapping(value = "/autoscaling/{userId}/{clusterId}/alert-rule", method = RequestMethod.GET)
    public List<AutoScalingAlertRuleVO> getAutoScalingAlertRule(@Validated @PathVariable String userId,
            @Validated @PathVariable String clusterId) {
        return alertAutoScalingService.getAutoScalingAlertRule(userId, clusterId);
    }

    @RequestMapping(value = "/autoscaling/alert-rule", method = RequestMethod.POST)
    public List<AutoScalingAlertRuleVO> AutoScalingAlertRule(@RequestBody List<ModifyAlertRuleVO> modifyAlertRuleVOs) {
        return alertAutoScalingService.AutoScalingAlertRule(modifyAlertRuleVOs);
    }

}
