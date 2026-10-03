package com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.mappers;

import com.backintro.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.infrastructure.mentalstatusexam.adapters.out.persistence.entity.MentalStatusExamJpaEntity;

public class MentalStatusExamPersistenceMapper {
    public MentalStatusExamJpaEntity toJpa(MentalStatusExam aggregate) {
        if (aggregate == null) return null;
        return new MentalStatusExamJpaEntity(aggregate.id().value(), aggregate.encounterId(), aggregate.appearance(), aggregate.behavior(), aggregate.attitude(), aggregate.consciousness(), aggregate.orientation(), aggregate.attention(), aggregate.memory(), aggregate.speech(), aggregate.mood(), aggregate.affect(), aggregate.thoughtProcess(), aggregate.thoughtContent(), aggregate.perception(), aggregate.judgment(), aggregate.insight(), aggregate.psychomotorActivity(), aggregate.observations(), aggregate.createdAt(), aggregate.createdBy());
    }

    public MentalStatusExam toDomain(MentalStatusExamJpaEntity entityObj) {
        if (entityObj == null) return null;
        return MentalStatusExam.restore(new MentalStatusExamId(entityObj.getId()), entityObj.getEncounterId(), entityObj.getAppearance(), entityObj.getBehavior(), entityObj.getAttitude(), entityObj.getConsciousness(), entityObj.getOrientation(), entityObj.getAttention(), entityObj.getMemory(), entityObj.getSpeech(), entityObj.getMood(), entityObj.getAffect(), entityObj.getThoughtProcess(), entityObj.getThoughtContent(), entityObj.getPerception(), entityObj.getJudgment(), entityObj.getInsight(), entityObj.getPsychomotorActivity(), entityObj.getObservations(), entityObj.getCreatedAt(), entityObj.getCreatedBy());
    }
}
