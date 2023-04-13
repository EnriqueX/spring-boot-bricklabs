package com.egox.step01.repositories;

import com.egox.step01.models.Order;
import com.egox.step01.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByIdAndUser(Long id, User user);
}
