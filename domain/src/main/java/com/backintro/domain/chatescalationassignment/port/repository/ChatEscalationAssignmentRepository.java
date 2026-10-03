package com.backintro.domain.chatescalationassignment.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

public interface ChatEscalationAssignmentRepository {
    ChatEscalationAssignment save(ChatEscalationAssignment aggregate);
    Optional<ChatEscalationAssignment> findById(ChatEscalationAssignmentId id);
    List<ChatEscalationAssignment> findAll();
    void delete(ChatEscalationAssignment aggregate);
}
