package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
       int id = jdbc.update("insert into accident (name, text, address, accident_tipe_id) values (?, ?, ?, ?)",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getAccidentType().getId());
        return accident;
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("Address"));
                    return accident;
                });
    }


    public List<AccidentType> getTypes() {
        return jdbc.query("select id, name from accident_type", (rs, row) -> {
            AccidentType accidentType = new AccidentType();
            accidentType.setId(rs.getInt("id"));
            accidentType.setName(rs.getString("name"));
            return accidentType;
        });

    }

    public AccidentType getType(int id) {
        return jdbc.queryForObject("select id, name from accident_type where id = ?",
        (resultSet, rowNum) -> {
            AccidentType accident = new AccidentType();
            accident.setId(resultSet.getInt("id"));
            accident.setName(resultSet.getString("name"));
            return accident; },
                id);
    }


     public Rule getRule(int id) {
         return jdbc.queryForObject("select id, name from rules where id = ?",
                 (resultSet, rowNum) -> {
                     Rule rule = new Rule();
                     rule.setId(resultSet.getInt("id"));
                     rule.setName(resultSet.getString("name"));
                     return rule; },
                 id);
     }


    public List<Rule> getRules() {
        return jdbc.query("select id, name from rules", (rs, row) -> {
            Rule rule = new Rule();
            rule.setId(rs.getInt("id"));
            rule.setName(rs.getString("name"));
            return rule;
        });
    }

    public Accident findById(int id) {
        return jdbc.queryForObject("select id, name, text, address from accident where id = ?",
                        (resultSet, rowNum) -> {
                            Accident accident = new Accident();
                            accident.setId(resultSet.getInt("id"));
                            accident.setName(resultSet.getString("name"));
                            accident.setText(resultSet.getString("text"));
                            accident.setAddress(resultSet.getString("address"));
                            return accident; },
                        id);

    }

    public void update(int id, Accident accident) {
        jdbc.update(
                "update accident set name = ?, text = ?, address = ?, accident_tipe_id = ?  where id = ?",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getAccidentType().getId(), id);
    }

    public void addIntoAccidentsRules(int rules, int accident) {
        jdbc.update("insert into accidents_rules ( rules_id, accidents_id) values (?, ?)",
                rules, accident);
    }

}
