package com.example.ebor.mapper;

import com.example.ebor.model.SysRole;
import com.example.ebor.model.SysRoleExample.Criteria;
import com.example.ebor.model.SysRoleExample.Criterion;
import com.example.ebor.model.SysRoleExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SysRoleSqlProvider {

    public String countByExample(SysRoleExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_role");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysRoleExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_role");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_role");
        
        if (record.getRoleId() != null) {
            sql.VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            sql.VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleRemark() != null) {
            sql.VALUES("role_remark", "#{roleRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getJurisdiction() != null) {
            sql.VALUES("jurisdiction", "#{jurisdiction,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysRoleExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("role_id");
        } else {
            sql.SELECT("role_id");
        }
        sql.SELECT("role_name");
        sql.SELECT("role_remark");
        sql.SELECT("jurisdiction");
        sql.SELECT("create_time");
        sql.FROM("sys_role");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysRole record = (SysRole) parameter.get("record");
        SysRoleExample example = (SysRoleExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        if (record.getRoleId() != null) {
            sql.SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleName() != null) {
            sql.SET("role_name = #{record.roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleRemark() != null) {
            sql.SET("role_remark = #{record.roleRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getJurisdiction() != null) {
            sql.SET("jurisdiction = #{record.jurisdiction,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        sql.SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        sql.SET("role_name = #{record.roleName,jdbcType=VARCHAR}");
        sql.SET("role_remark = #{record.roleRemark,jdbcType=VARCHAR}");
        sql.SET("jurisdiction = #{record.jurisdiction,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        
        SysRoleExample example = (SysRoleExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysRole record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_role");
        
        if (record.getRoleName() != null) {
            sql.SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getRoleRemark() != null) {
            sql.SET("role_remark = #{roleRemark,jdbcType=VARCHAR}");
        }
        
        if (record.getJurisdiction() != null) {
            sql.SET("jurisdiction = #{jurisdiction,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("role_id = #{roleId,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysRoleExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}