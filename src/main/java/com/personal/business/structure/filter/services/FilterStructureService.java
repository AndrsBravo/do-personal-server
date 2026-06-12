package com.personal.business.structure.filter.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.personal.backoffice.user.entities.User;
import com.personal.business.structure.entities.Structure;
import com.personal.business.structure.factories.StructureResultFactory;
import com.personal.shared.query.Query;
import com.personal.shared.services.IFilterService;
import com.personal.shared.services.ServiceResult;

import io.helidon.dbclient.DbClient;

public class FilterStructureService implements IFilterService<Structure> {

    private final Optional<DbClient> dbClient;

    public FilterStructureService(Optional<DbClient> dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public ServiceResult<List<Structure>> filter(Query query) {

        if (dbClient.isEmpty()) {
            return StructureResultFactory.FetchNull();
        }

        var queryString = query.Select("business_structures",
                "id", "bss_structure", "bss_title", "bss_description", "updated_at", "created_at", "created_by")
                .Get();

        //System.out.println(queryString);
        var result = this.dbClient.get().execute()
                .createQuery(queryString)
                .params(query.getParams())
                .execute()
                .map((dbRow) -> {
                    var u = new Structure();
                    u.setId(dbRow.column("id").getString());
                    u.setStructure(dbRow.column("bss_structure").getString());
                    u.setTitle(dbRow.column("bss_title").getString());
                    u.setDescription(dbRow.column("bss_description").getString());
                    u.setCreatedAt(dbRow.column("created_at").get(LocalDateTime.class));
                    u.setUpdatedAt(dbRow.column("updated_at").get(LocalDateTime.class));
                    u.setCreatedBy(new User(dbRow.column("created_by").getString()));
                    return u;
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            return StructureResultFactory.FetchNull();
        }

        return StructureResultFactory.FetchResult(result);
    }
}
