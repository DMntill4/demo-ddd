package com.backintro.domain.messagetype.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public interface MessageTypeRepository {
    MessageType save(MessageType aggregate);
    Optional<MessageType> findById(MessageTypeId id);
    List<MessageType> findAll();
    void delete(MessageType aggregate);
}
