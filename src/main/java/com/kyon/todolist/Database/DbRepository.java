package com.kyon.todolist.Database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DbRepository extends JpaRepository<DbTodo, Integer> {
    @Query("select a from DbTodo a where a.comment like %:keyword% order by a.deadlineDt asc")
    List<DbTodo> findComment(@Param("keyword") String keyword);
    @Query("select a from DbTodo a where a.comment like :keyword")
    List<DbTodo> findExactMatch(@Param("keyword") String keyword);
}
