package com.gxtravel.service;

import com.gxtravel.entity.QueryVo;
import com.gxtravel.entity.Ticket;
import com.gxtravel.utils.Page;

import java.util.List;

public interface TicketService {
    Page<Ticket> selectTicketPageByQueryVo(QueryVo vo);
    List<Ticket> selectTicketListByFid(Integer fid);
    double selectPriceByFid(Integer fid);
    void deleteById(Integer id);
    void addTicket(Ticket ticket);
    int updateTicket(Ticket ticket);
    Ticket getTicketById(Integer id);
}
