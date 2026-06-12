package com.personal.business.structure.factories;

import com.personal.business.structure.create.services.CreateStructureService;
import com.personal.business.structure.delete.services.DeleteStructureService;
import com.personal.business.structure.filter.services.FilterStructureService;
import com.personal.business.structure.update.services.EditStructureService;
import com.personal.server.dbclient.DbClientMSSQLFactory;

public class StructureServiceFactory {

    public static CreateStructureService CreateStructure(String dbClient) {

        return new CreateStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static FilterStructureService FilterStructure(String dbClient) {

        return new FilterStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static EditStructureService EditStructure(String dbClient) {

        return new EditStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

    public static DeleteStructureService DeleteStructure(String dbClient) {

        return new DeleteStructureService(DbClientMSSQLFactory.DbClient(dbClient));
    }

}
