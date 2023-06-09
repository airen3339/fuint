package com.fuint.application.service.sendlog;

import com.fuint.base.annoation.OperationServiceLog;
import com.fuint.base.dao.pagination.PaginationRequest;
import com.fuint.base.dao.pagination.PaginationResponse;
import com.fuint.exception.BusinessCheckException;
import com.fuint.application.dao.entities.MtSendLog;
import com.fuint.application.dao.repositories.MtSendLogRepository;
import com.fuint.application.dto.ReqSendLogDto;
import com.fuint.application.enums.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.String;
import java.util.*;

/**
 * 发送卡券记录业务实现类
 * Created by FSQ
 * Contact wx fsq_better
 * Site https://www.fuint.cn
 */
@Service
public class SendLogServiceImpl implements SendLogService {

    private static final Logger log = LoggerFactory.getLogger(SendLogServiceImpl.class);

    @Autowired
    private MtSendLogRepository sendLogRepository;

    /**
     * 分页查询列表
     *
     * @param paginationRequest
     * @return
     */
    @Override
    public PaginationResponse<MtSendLog> querySendLogListByPagination(PaginationRequest paginationRequest) {
        paginationRequest.setSortColumn(new String[]{"id desc", "status asc"});
        PaginationResponse<MtSendLog> paginationResponse = sendLogRepository.findResultsByPagination(paginationRequest);
        return paginationResponse;
    }

    /**
     * 添加发放记录
     *
     * @param reqSendLogDto
     * @throws BusinessCheckException
     */
    @Override
    @OperationServiceLog(description = "添加发券记录")
    public MtSendLog addSendLog(ReqSendLogDto reqSendLogDto) {
        MtSendLog log = new MtSendLog();

        log.setType(reqSendLogDto.getType().byteValue());
        log.setUserId(reqSendLogDto.getUserId());
        log.setFileName(reqSendLogDto.getFileName());
        log.setFilePath(reqSendLogDto.getFilePath());
        log.setMobile(reqSendLogDto.getMobile());
        log.setCouponId(reqSendLogDto.getCouponId());
        log.setGroupId(reqSendLogDto.getGroupId());
        log.setGroupName(reqSendLogDto.getGroupName());
        log.setSendNum(reqSendLogDto.getSendNum());
        log.setRemoveSuccessNum(0);
        log.setRemoveFailNum(0);
        log.setStatus(StatusEnum.ENABLED.getKey());
        log.setCreateTime(new Date());
        log.setOperator(reqSendLogDto.getOperator());
        log.setUuid(reqSendLogDto.getUuid());

        sendLogRepository.save(log);

        return log;
    }

    /**
     * 根据ID查询发券记录
     *
     * @param id ID
     * @throws BusinessCheckException
     */
    @Override
    public MtSendLog querySendLogById(Long id) {
        return sendLogRepository.findOne(id.intValue());
    }

    /**
     * 根据ID 删除发券记录
     *
     * @param id       发券记录ID
     * @param operator 操作人
     * @throws BusinessCheckException
     */
    @Override
    @OperationServiceLog(description = "删除发券记录")
    public void deleteSendLog(Long id, String operator) throws BusinessCheckException {
        MtSendLog couponGroup = this.querySendLogById(id);

        if (null == couponGroup) {
            return;
        }

        couponGroup.setStatus(StatusEnum.DISABLE.getKey());

        // 操作人
        couponGroup.setOperator(operator);

        sendLogRepository.save(couponGroup);
    }
}
