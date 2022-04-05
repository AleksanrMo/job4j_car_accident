package ru.job4j.accident.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;
import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private  AccidentRepository repository;
    private  AccidentTypeRepository accidentTypeRepository;
    private  RuleRepository ruleRepository;

    @Autowired
    public void setRepository(AccidentRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setAccidentTypeRepository(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    @Autowired
    public void setRuleRepository(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public Accident save(Accident accident) {
        return repository.save(accident);
    }

    @Override
    public List<Accident> getAll() {
        return repository.findAll();
    }

    @Override
    public List<AccidentType> getTypes() {
        return accidentTypeRepository.findAll();
    }

    @Override

    public AccidentType getType(int id) {
        return accidentTypeRepository.findById(id).get();
    }

    @Override
    public Rule getRule(int id) {
        return ruleRepository.findById(id).get();
    }

    @Override
    public List<Rule> getRules() {
        return ruleRepository.findAll();
    }

    @Override
    public Accident findById(int id) {
        return repository.findById(id).get();
    }
}
