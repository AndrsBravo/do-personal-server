USE system_master;
GO -- Table dbo.user_types
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'user_types'
    ) BEGIN CREATE TABLE dbo.user_types (
        id VARCHAR(12) NOT NULL,
        ust_type VARCHAR(16) NOT NULL,
        ust_title VARCHAR(16) NOT NULL,
        ust_description VARCHAR(100) NOT NULL,
        ust_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ust_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ust_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_user_types PRIMARY KEY (id),
        CONSTRAINT UQ_user_types_id UNIQUE (id)
    );
END
GO -- Table dbo.users
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'users'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.users (
        id VARCHAR(12) NOT NULL,
        user_types_id VARCHAR(12) NOT NULL,
        us_email VARCHAR(60) NOT NULL,
        user_name VARCHAR(16) NOT NULL,
        us_name VARCHAR(45) NOT NULL,
        us_last_name VARCHAR(45) NOT NULL,
        us_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        us_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        us_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_users PRIMARY KEY (id),
        CONSTRAINT UQ_users_id UNIQUE (id),
        CONSTRAINT UQ_users_email UNIQUE (us_email),
        CONSTRAINT UQ_users_username UNIQUE (user_name),
    );
END
GO -- Table dbo.user_credentials
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'user_credentials'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.user_credentials (
        id VARCHAR(12) NOT NULL,
        user_id VARCHAR(12) NOT NULL,
        password VARCHAR(88) NOT NULL,
        salt BINARY(16) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_user_credentials PRIMARY KEY (id),
        CONSTRAINT UQ_user_credentials_id UNIQUE (id),
        CONSTRAINT FK_user_credentials_user FOREIGN KEY (user_id) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_user_credentials_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_user_credentials_user ON dbo.user_credentials (user_id ASC);
END
GO IF NOT EXISTS (
        SELECT *
        FROM user_types
        WHERE id = 'H06A10L07A12'
    ) BEGIN
INSERT INTO user_types (
        id,
        ust_type,
        ust_title,
        ust_description,
        ust_created_by
    )
VALUES (
        'H06A10L07A12',
        'system_default',
        'System Default',
        'System default administrator with full access',
        'H13A11L26A31'
    )
END;
GO IF NOT EXISTS (
        SELECT *
        FROM users
        WHERE id = 'H13A11L26A31'
    ) BEGIN
INSERT INTO users (
        id,
        user_types_id,
        us_email,
        user_name,
        us_name,
        us_last_name,
        us_created_by
    )
VALUES (
        'H13A11L26A31',
        'H06A10L07A12',
        'hubravo13@gmail.com',
        'systemdefault',
        'system',
        'default',
        'H13A11L26A31'
    )
END;
GO
ALTER TABLE dbo.users
ADD CONSTRAINT fk_users_user_types FOREIGN KEY (user_types_id) REFERENCES dbo.user_types (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO
ALTER TABLE dbo.users
ADD CONSTRAINT fk_users_user_created_by FOREIGN KEY (us_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO CREATE INDEX IX_users_user_types ON dbo.users (user_types_id ASC);
GO
ALTER TABLE dbo.user_types
ADD CONSTRAINT fk_type_created_by FOREIGN KEY (ust_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO CREATE INDEX IX_user_types_created_by ON dbo.user_types (ust_created_by ASC);
GO -- Table dbo.client_types
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'client_types'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.client_types (
        id VARCHAR(12) NOT NULL,
        ct_type VARCHAR(16) NOT NULL,
        ct_title VARCHAR(100) NOT NULL,
        ct_description VARCHAR(250) NOT NULL,
        ct_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ct_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ct_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_client_types PRIMARY KEY (id),
        CONSTRAINT UQ_client_types_id UNIQUE (id),
        CONSTRAINT FK_ct_created_by FOREIGN KEY (ct_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_client_types_created_by ON dbo.client_types (ct_created_by ASC);
END
GO -- Table dbo.countries
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'countries'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.countries (
        id VARCHAR(12) NOT NULL,
        oc_code VARCHAR(12) NOT NULL,
        oc_name VARCHAR(150) NOT NULL,
        oc_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        oc_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        oc_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_countries PRIMARY KEY (id),
        CONSTRAINT UQ_countries_id UNIQUE (id),
        CONSTRAINT UQ_countries_code UNIQUE (oc_code),
        CONSTRAINT UQ_countries_name UNIQUE (oc_name),
        CONSTRAINT UQ_countries_created_by UNIQUE (oc_created_by),
        CONSTRAINT fk_countries_oc_created_by FOREIGN KEY (oc_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_countries_created_by ON dbo.countries (oc_created_by ASC);
END
GO -- Table dbo.clients
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'clients'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.clients (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(12) NOT NULL,
        c_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        c_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        c_created_by VARCHAR(12) NOT NULL,
        c_types_id VARCHAR(12) NOT NULL,
        CONSTRAINT PK_clients PRIMARY KEY (id),
        CONSTRAINT UQ_clients_id UNIQUE (id),
        CONSTRAINT UQ_clients_types_id UNIQUE (c_types_id),
        CONSTRAINT fk_client_created_by FOREIGN KEY (c_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_client_country FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_clients_client_types_id FOREIGN KEY (c_types_id) REFERENCES dbo.client_types (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_clients_created_by ON dbo.clients (c_created_by ASC);
CREATE INDEX IX_clients_country ON dbo.clients (country_id ASC);
CREATE INDEX IX_clients_client_types ON dbo.clients (c_types_id ASC);
END
GO -- Table dbo.business
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business (
        id VARCHAR(12) NOT NULL,
        client_id VARCHAR(12) NOT NULL,
        country_id VARCHAR(12) NOT NULL,
        bss_name VARCHAR(100) NOT NULL,
        bss_db_name VARCHAR(16) NOT NULL,
        bss_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        bss_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        bss_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business PRIMARY KEY (id),
        CONSTRAINT UQ_business_id UNIQUE (id),
        CONSTRAINT FK_business_created_by FOREIGN KEY (bss_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_country FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_client FOREIGN KEY (client_id) REFERENCES dbo.clients (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_created_by ON dbo.business (bss_created_by ASC);
CREATE INDEX IX_business_country ON dbo.business (country_id ASC);
CREATE INDEX IX_business_client ON dbo.business (client_id ASC);
END
GO -- Table dbo.commercial_plan
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'commercial_plan'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.commercial_plan (
        id VARCHAR(12) NOT NULL,
        cp_plan VARCHAR(16) NOT NULL,
        cp_title VARCHAR(60) NOT NULL,
        cp_description VARCHAR(250) NULL,
        cp_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        cp_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        cp_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_commercial_plan PRIMARY KEY (id),
        CONSTRAINT UQ_commercial_plan_id UNIQUE (id),
        CONSTRAINT FK_commercial_plan_created_by FOREIGN KEY (cp_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_commercial_plan_created_by ON dbo.commercial_plan (cp_created_by ASC);
END
GO -- Table dbo.commercial_entities
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'commercial_entities'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.commercial_entities (
        id VARCHAR(12) NOT NULL,
        ce_entity VARCHAR(16) NOT NULL,
        ce_title VARCHAR(100) NOT NULL,
        ce_description VARCHAR(250) NULL,
        ce_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ce_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ce_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_commercial_entities PRIMARY KEY (id),
        CONSTRAINT UQ_commercial_entities_id UNIQUE (id),
        CONSTRAINT FK_commercial_entities_created_by FOREIGN KEY (ce_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_commercial_entities_created_by ON dbo.commercial_entities (ce_created_by ASC);
END
GO -- Table dbo.commercial_plan_details
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'commercial_plan_details'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.commercial_plan_details (
        id VARCHAR(12) NOT NULL,
        commercial_plan_id VARCHAR(12) NOT NULL,
        commercial_entities_id VARCHAR(12) NOT NULL,
        cpd_quantity INT NOT NULL,
        cpd_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        cpd_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        cpd_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_commercial_plan_details PRIMARY KEY (id),
        CONSTRAINT UQ_commercial_plan_details_id UNIQUE (id),
        CONSTRAINT FK_cpd_created_by FOREIGN KEY (cpd_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_commercial_plan_details_commercial_plan FOREIGN KEY (commercial_plan_id) REFERENCES dbo.commercial_plan (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_commercial_plan_details_commercial_entities FOREIGN KEY (commercial_entities_id) REFERENCES dbo.commercial_entities (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_cpd_created_by ON dbo.commercial_plan_details (cpd_created_by ASC);
CREATE INDEX IX_cpd_plan ON dbo.commercial_plan_details (commercial_plan_id ASC);
CREATE INDEX IX_cpd_entities ON dbo.commercial_plan_details (commercial_entities_id ASC);
END
GO -- Table dbo.user_role
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'user_role'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.user_role (
        id VARCHAR(12) NOT NULL,
        url_role VARCHAR(16) NOT NULL,
        url_title VARCHAR(60) NOT NULL,
        url_description VARCHAR(200) NULL,
        url_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        url_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        url_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_user_role PRIMARY KEY (id),
        CONSTRAINT UQ_user_role_id UNIQUE (id),
        CONSTRAINT FK_user_role_created_by FOREIGN KEY (url_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_user_role_created_by ON dbo.user_role (url_created_by ASC);
END
GO -- Table dbo.user_relation
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'user_relation'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.user_relation (
        id VARCHAR(12) NOT NULL,
        ur_relation VARCHAR(16) NOT NULL,
        ur_title VARCHAR(60) NOT NULL,
        ur_description VARCHAR(200) NULL,
        ur_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ur_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ur_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_user_relation PRIMARY KEY (id),
        CONSTRAINT UQ_user_relation_id UNIQUE (id),
        CONSTRAINT FK_user_relation_created_by FOREIGN KEY (ur_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_user_relation_created_by ON dbo.user_relation (ur_created_by ASC);
END
GO -- Table dbo.user_has_clients
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'user_has_clients'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.user_has_clients (
        client_id VARCHAR(12) NOT NULL,
        users_id VARCHAR(12) NOT NULL,
        user_role_id VARCHAR(12) NOT NULL,
        user_relation_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT FK_uhc_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_user_has_clients_client_id FOREIGN KEY (client_id) REFERENCES dbo.clients (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_clients_users_id FOREIGN KEY (users_id) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_clients_user_role_id FOREIGN KEY (user_role_id) REFERENCES dbo.user_role (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_clients_user_relation1 FOREIGN KEY (user_relation_id) REFERENCES dbo.user_relation (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_uhc_created_by ON dbo.user_has_clients (created_by ASC);
CREATE INDEX IX_uhc_client ON dbo.user_has_clients (client_id ASC);
CREATE INDEX IX_uhc_users ON dbo.user_has_clients (users_id ASC);
CREATE INDEX IX_uhc_role ON dbo.user_has_clients (user_role_id ASC);
CREATE INDEX IX_uhc_relation ON dbo.user_has_clients (user_relation_id ASC);
END
GO -- Table dbo.user_has_business
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'user_has_business'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.user_has_business (
        business_id VARCHAR(12) NOT NULL,
        users_id VARCHAR(12) NOT NULL,
        user_relation_id VARCHAR(12) NOT NULL,
        user_role_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT FK_uhb_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_business_business_id FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_business_users_id FOREIGN KEY (users_id) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_business_user_role_id FOREIGN KEY (user_role_id) REFERENCES dbo.user_role (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_user_has_business_user_relation_id FOREIGN KEY (user_relation_id) REFERENCES dbo.user_relation (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_uhb_created_by ON dbo.user_has_business (created_by ASC);
CREATE INDEX IX_uhb_business ON dbo.user_has_business (business_id ASC);
CREATE INDEX IX_uhb_users ON dbo.user_has_business (users_id ASC);
CREATE INDEX IX_uhb_role ON dbo.user_has_business (user_role_id ASC);
CREATE INDEX IX_uhb_relation ON dbo.user_has_business (user_relation_id ASC);
END
GO -- Table dbo.client_commercial_plan
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'client_commercial_plan'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.client_commercial_plan (
        id VARCHAR(12) NOT NULL,
        client_id VARCHAR(12) NOT NULL,
        commercial_plan_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_client_commercial_plan PRIMARY KEY (id),
        CONSTRAINT UQ_client_commercial_plan_id UNIQUE (id),
        CONSTRAINT FK_ccp_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_client_commercial_plan_client FOREIGN KEY (client_id) REFERENCES dbo.clients (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_client_commercial_plan_commercial_plan FOREIGN KEY (commercial_plan_id) REFERENCES dbo.commercial_plan (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_ccp_created_by ON dbo.client_commercial_plan (created_by ASC);
CREATE INDEX IX_ccp_client ON dbo.client_commercial_plan (client_id ASC);
CREATE INDEX IX_ccp_plan ON dbo.client_commercial_plan (commercial_plan_id ASC);
END
GO -- Table dbo.client_commercial_plan_details
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'client_commercial_plan_details'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.client_commercial_plan_details (
        id VARCHAR(12) NOT NULL,
        client_id VARCHAR(12) NOT NULL,
        commercial_plan_id VARCHAR(12) NOT NULL,
        commercial_entities_id VARCHAR(12) NOT NULL,
        ccpd_quantity INT NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_client_commercial_plan_details PRIMARY KEY (id),
        CONSTRAINT UQ_client_commercial_plan_details_id UNIQUE (id),
        CONSTRAINT FK_ccpd_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_client_commercial_plan_details_client_id FOREIGN KEY (client_id) REFERENCES dbo.clients (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_client_commercial_plan_details_commercial_plan_id FOREIGN KEY (commercial_plan_id) REFERENCES dbo.commercial_plan (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT fk_client_commercial_plan_details_commercial_entities_id FOREIGN KEY (commercial_entities_id) REFERENCES dbo.commercial_entities (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_ccpd_created_by ON dbo.client_commercial_plan_details (created_by ASC);
CREATE INDEX IX_ccpd_client ON dbo.client_commercial_plan_details (client_id ASC);
CREATE INDEX IX_ccpd_plan ON dbo.client_commercial_plan_details (commercial_plan_id ASC);
CREATE INDEX IX_ccpd_entities ON dbo.client_commercial_plan_details (commercial_entities_id ASC);
END
GO