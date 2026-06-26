-- Table dbo.users
IF NOT EXISTS (
    SELECT *
    FROM sys.tables
    WHERE name = 'users'
        AND schema_id = SCHEMA_ID('dbo')
) BEGIN CREATE TABLE dbo.users (
    id VARCHAR(12) NOT NULL,
    us_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    us_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
    us_created_by VARCHAR(12) NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY (id),
    CONSTRAINT UQ_users_id UNIQUE (id),
    CONSTRAINT UQ_users_created_by UNIQUE (us_created_by),
    CONSTRAINT FK_users_us_created_by FOREIGN KEY (us_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX IX_users_created_by ON dbo.users (us_created_by ASC);
END;
GO -- insert default user
    IF NOT EXISTS (
        SELECT *
        FROM users
        WHERE id = 'H13A11L26A31'
    ) BEGIN
INSERT INTO users (id, us_created_by)
VALUES (
        'H13A11L26A31',
        'H13A11L26A31'
    )
END;
GO -- Table dbo.countries
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'countries'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.countries (
        id VARCHAR(8) NOT NULL,
        co_created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        co_updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        co_created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_countries PRIMARY KEY (id),
        CONSTRAINT UQ_countries_id UNIQUE (id),
        CONSTRAINT UQ_countries_created_by UNIQUE (co_created_by),
        CONSTRAINT FK_countries_co_created_by FOREIGN KEY (co_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_countries_created_by ON dbo.countries (co_created_by ASC);
END
GO -- Table dbo.temporal_frequencies
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'temporal_frequencies'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.temporal_frequencies (
        id VARCHAR(8) NOT NULL,
        tf_title VARCHAR(100) NOT NULL,
        tf_frequency VARCHAR(8) NOT NULL,
        tf_description VARCHAR(250) NULL,
        country_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_temporal_frequencies PRIMARY KEY (id),
        CONSTRAINT UQ_temporal_frequencies_id UNIQUE (id),
        CONSTRAINT FK_temporal_frequencies_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_temporal_frequencies_country FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_temporal_frequencies_created_by ON dbo.temporal_frequencies (created_by ASC);
CREATE INDEX IX_temporal_frequencies_country ON dbo.temporal_frequencies (country_id ASC);
END
GO -- Table dbo.organization_structures
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'organization_structures'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.organization_structures (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        orgs_structure VARCHAR(16) NOT NULL,
        orgs_title VARCHAR(100) NOT NULL,
        orgs_description VARCHAR(250) NULL,
        orgs_level TINYINT NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_organization_structures PRIMARY KEY (id),
        CONSTRAINT UQ_organization_structures_id UNIQUE (id),
        CONSTRAINT FK_organization_structures_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_structures_country_id FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_organization_structures_created_by ON dbo.organization_structures (created_by ASC);
CREATE INDEX IX_organization_structures_country_id ON dbo.organization_structures (country_id ASC);
END
GO -- Table dbo.organization_hierarchies
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'organization_hierarchies'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.organization_hierarchies (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        orgh_hierarchy VARCHAR(16) NOT NULL,
        orgh_title VARCHAR(100) NOT NULL,
        orgh_description VARCHAR(250) NOT NULL,
        orgh_level TINYINT NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_organization_hierarchies PRIMARY KEY (id),
        CONSTRAINT UQ_organization_hierarchy_id UNIQUE (id),
        CONSTRAINT FK_organization_hierarchies_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_hierarchies_country_id FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_organization_hierarchies_created_by ON dbo.organization_hierarchies (created_by ASC);
CREATE INDEX IX_organization_hierarchies_country_id ON dbo.organization_hierarchies (country_id ASC);
END
GO -- Table dbo.organization_relations
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'organization_relations'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.organization_relations (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        organization_structure VARCHAR(8) NOT NULL,
        organization_hierarchy VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_organization_relations PRIMARY KEY (id),
        CONSTRAINT UQ_organization_relations UNIQUE (id),
        CONSTRAINT FK_organization_relations_organization_structure FOREIGN KEY (organization_structure) REFERENCES dbo.organization_structures (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_relations_organization_hierarchy FOREIGN KEY (organization_hierarchy) REFERENCES dbo.organization_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_relations_country_id FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_relations_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    );
CREATE INDEX IX_organization_relations_created_by ON dbo.organization_relations (created_by ASC);
CREATE INDEX IX_organization_relations_country_id ON dbo.organization_relations (country_id ASC);
CREATE INDEX IX_organization_relations_organization_structure ON dbo.organization_relations (organization_structure ASC);
CREATE INDEX IX_organization_relations_organization_hierarchy ON dbo.organization_relations (organization_hierarchy ASC);
END
GO -- Table dbo.finance_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'finance_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.finance_categories (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        fc_benefit_or_deduction CHAR(1) NOT NULL,
        fc_category VARCHAR(8) NOT NULL,
        fc_title VARCHAR(100) NOT NULL,
        fc_description VARCHAR(200) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_finance_categories PRIMARY KEY (id),
        CONSTRAINT UQ_finance_categories_id UNIQUE (id),
        CONSTRAINT FK_finance_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_finance_categories_country_id FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_finance_categories_created_by ON dbo.finance_categories (created_by ASC);
CREATE INDEX IX_finance_categories_country_id ON dbo.finance_categories (country_id ASC);
END
GO -- Table dbo.origin_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'origin_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.origin_categories (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        co_origin VARCHAR(8) NOT NULL,
        co_title VARCHAR(100) NOT NULL,
        co_description VARCHAR(200) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_origin_categories PRIMARY KEY (id),
        CONSTRAINT UQ_origin_categories_id UNIQUE (id),
        CONSTRAINT FK_origin_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_origin_categories_country_id FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_origin_categories_created_by ON dbo.origin_categories (created_by ASC);
CREATE INDEX IX_origin_categories_country_id ON dbo.origin_categories (country_id ASC);
END
GO -- Table dbo.benefit_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'benefit_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.benefit_categories (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        bc_category VARCHAR(150) NOT NULL,
        bc_title VARCHAR(150) NOT NULL,
        bc_description VARCHAR(250) NULL,
        bc_finance_category_id VARCHAR(8) NOT NULL,
        bc_origin_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_benefit_categories PRIMARY KEY (id),
        CONSTRAINT UQ_benefit_categories_id UNIQUE (id),
        CONSTRAINT FK_benefit_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefit_categories_finance_type FOREIGN KEY (bc_finance_category_id) REFERENCES dbo.finance_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefit_categories_origin FOREIGN KEY (bc_origin_id) REFERENCES dbo.origin_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefit_categories_country FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_benefit_categories_created_by ON dbo.benefit_categories (created_by ASC);
CREATE INDEX IX_benefit_categories_finance ON dbo.benefit_categories (bc_finance_category_id ASC);
CREATE INDEX IX_benefit_categories_origin ON dbo.benefit_categories (bc_origin_id ASC);
CREATE INDEX IX_benefit_categories_country ON dbo.benefit_categories (country_id ASC);
END
GO -- Table dbo.business_benefits
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_benefits'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_benefits (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        benefit_category_id VARCHAR(8) NOT NULL,
        bb_benefit VARCHAR(8) NOT NULL,
        bb_title VARCHAR(150) NOT NULL,
        bb_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_business_benefits_id UNIQUE (id),
        CONSTRAINT FK_business_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_categories FOREIGN KEY (benefit_category_id) REFERENCES dbo.benefit_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_benefits_created_by ON dbo.business_benefits (created_by ASC);
CREATE INDEX IX_business_benefits_countries ON dbo.business_benefits (country_id ASC);
CREATE INDEX IX_business_benefits_categories ON dbo.business_benefits (benefit_category_id ASC);
END
GO -- Table dbo.business_benefits_rates
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_benefits_rates'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_benefits_rates (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        business_benefit_id VARCHAR(8) NOT NULL,
        temporal_frequency_id VARCHAR(8) NOT NULL,
        bbr_amount MONEY NOT NULL,
        bbr_base_amount MONEY NOT NULL,
        bbr_rate FLOAT NOT NULL,
        bbr_level TINYINT NOT NULL,
        bbr_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        bbr_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_benefits_rates PRIMARY KEY (id),
        CONSTRAINT UQ_business_benefits_rates_id UNIQUE (id),
        CONSTRAINT FK_business_benefits_rates_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_rates_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_rates_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_rates_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_benefits_rates_created_by ON dbo.business_benefits_rates (created_by ASC);
CREATE INDEX IX_business_benefits_rates_countries ON dbo.business_benefits_rates (country_id ASC);
CREATE INDEX IX_business_benefits_rates_benefits ON dbo.business_benefits_rates (business_benefit_id ASC);
CREATE INDEX IX_business_benefits_rates_temporal_frequency ON dbo.business_benefits_rates (temporal_frequency_id ASC);
END
GO -- Table dbo.deductions_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'deductions_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.deductions_categories (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        dc_title VARCHAR(150) NOT NULL,
        dc_description VARCHAR(250) NULL,
        dc_finance_category_id VARCHAR(8) NOT NULL,
        dc_origin_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_deductions_categories PRIMARY KEY (id),
        CONSTRAINT UQ_deductions_categories_id UNIQUE (id),
        CONSTRAINT FK_deductions_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_deductions_categories_finance_type FOREIGN KEY (dc_finance_category_id) REFERENCES dbo.finance_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_deductions_categories_origin FOREIGN KEY (dc_origin_id) REFERENCES dbo.origin_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_deductions_categories_country FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_deductions_categories_created_by ON dbo.deductions_categories (created_by ASC);
CREATE INDEX IX_deductions_categories_finance ON dbo.deductions_categories (dc_finance_category_id ASC);
CREATE INDEX IX_deductions_categories_origin ON dbo.deductions_categories (dc_origin_id ASC);
CREATE INDEX IX_deductions_categories_country ON dbo.deductions_categories (country_id ASC);
END
GO -- Table dbo.business_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_deductions (
        id VARCHAR(8) NOT NULL,
        bd_deduction VARCHAR(8) NOT NULL,
        bd_title VARCHAR(100) NOT NULL,
        bd_description VARCHAR(250) NULL,
        country_id VARCHAR(8) NOT NULL,
        finance_category_id VARCHAR(8) NOT NULL,
        origin_category_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_deductions PRIMARY KEY (id),
        CONSTRAINT UQ_business_deductions_id UNIQUE (id),
        CONSTRAINT FK_business_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_finance_type FOREIGN KEY (finance_category_id) REFERENCES dbo.finance_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_origin FOREIGN KEY (origin_category_id) REFERENCES dbo.origin_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_deductions_created_by ON dbo.business_deductions (created_by ASC);
CREATE INDEX IX_business_deductions_finance ON dbo.business_deductions (finance_category_id ASC);
CREATE INDEX IX_business_deductions_countries ON dbo.business_deductions (country_id ASC);
CREATE INDEX IX_business_deductions_origin ON dbo.business_deductions (origin_category_id ASC);
END
GO -- Table dbo.business_deductions_rates
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_deductions_rates'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_deductions_rates (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        business_deduction_id VARCHAR(8) NOT NULL,
        temporal_frequency_id VARCHAR(8) NOT NULL,
        bdr_amount MONEY NOT NULL,
        bdr_base_amount MONEY NOT NULL,
        bdr_rate FLOAT NOT NULL,
        bdr_level TINYINT NOT NULL,
        bdr_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        bdr_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_deductions_rates PRIMARY KEY (id),
        CONSTRAINT UQ_business_deductions_rates_id UNIQUE (id),
        CONSTRAINT FK_business_deductions_rates_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_rates_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_rates_deductions FOREIGN KEY (business_deduction_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_rates_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_deductions_rates_created_by ON dbo.business_deductions_rates (created_by ASC);
CREATE INDEX IX_business_deductions_rates_countries ON dbo.business_deductions_rates (country_id ASC);
CREATE INDEX IX_business_deductions_rates_deductions ON dbo.business_deductions_rates (business_deduction_id ASC);
CREATE INDEX IX_business_deductions_rates_temporal_frequency ON dbo.business_deductions_rates (temporal_frequency_id ASC);
END
GO -- Table dbo.benefits_deductions_base
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'benefits_deductions_base'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.benefits_deductions_base (
        id VARCHAR(8) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        business_benefit_id VARCHAR(8) NOT NULL,
        business_deduction_id VARCHAR(8) NOT NULL,
        bdb_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        bdb_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_benefits_deductions_base PRIMARY KEY (id),
        CONSTRAINT UQ_benefits_deductions_base_id UNIQUE (id),
        CONSTRAINT FK_benefits_deductions_base_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefits_deductions_base_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefits_deductions_base_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefits_deductions_base_deductions FOREIGN KEY (business_deduction_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_benefits_deductions_base_created_by ON dbo.benefits_deductions_base (created_by ASC);
CREATE INDEX IX_benefits_deductions_base_countries ON dbo.benefits_deductions_base (country_id ASC);
CREATE INDEX IX_benefits_deductions_base_benefits ON dbo.benefits_deductions_base (business_benefit_id ASC);
CREATE INDEX IX_benefits_deductions_base_deductions ON dbo.benefits_deductions_base (business_deduction_id ASC);
END
GO -- Table dbo.payrolls
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payrolls'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payrolls (
        id VARCHAR(12) NOT NULL,
        pr_title VARCHAR(100) NOT NULL,
        pr_payroll VARCHAR(16) NOT NULL,
        pr_description VARCHAR(250) NULL,
        country_id VARCHAR(8) NOT NULL,
        temporal_frequency_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payrolls PRIMARY KEY (id),
        CONSTRAINT UQ_payrolls_id UNIQUE (id),
        CONSTRAINT FK_payrolls_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payrolls_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payrolls_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payrolls_created_by ON dbo.payrolls (created_by ASC);
CREATE INDEX IX_payrolls_countries ON dbo.payrolls (country_id ASC);
CREATE INDEX IX_payrolls_temporal_frequency ON dbo.payrolls (temporal_frequency_id ASC);
END
GO -- Table dbo.payroll_benefits
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_benefits'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_benefits (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        business_benefit_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_benefits_id UNIQUE (id),
        CONSTRAINT FK_payroll_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_benefits_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_benefits_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_benefits_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_benefits_created_by ON dbo.payroll_benefits (created_by ASC);
CREATE INDEX IX_payroll_benefits_countries ON dbo.payroll_benefits (country_id ASC);
CREATE INDEX IX_payroll_benefits_payrolls ON dbo.payroll_benefits (payrolls_id ASC);
CREATE INDEX IX_payroll_benefits_benefits ON dbo.payroll_benefits (business_benefit_id ASC);
END
GO -- Table dbo.payroll_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_deductions (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        business_deduction_id VARCHAR(8) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_deductions PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_deductions_id UNIQUE (id),
        CONSTRAINT FK_payroll_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_deductions_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_deductions_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_deductions_deductions FOREIGN KEY (business_deduction_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_deductions_created_by ON dbo.payroll_deductions (created_by ASC);
CREATE INDEX IX_payroll_deductions_countries ON dbo.payroll_deductions (country_id ASC);
CREATE INDEX IX_payroll_deductions_payrolls ON dbo.payroll_deductions (payrolls_id ASC);
CREATE INDEX IX_payroll_deductions_deductions ON dbo.payroll_deductions (business_deduction_id ASC);
END
GO -- Table dbo.payroll_runs_types
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs_types'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs_types (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        prt_type VARCHAR(8) NOT NULL,
        prt_title VARCHAR(100) NOT NULL,
        prt_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_types PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_runs_types_id UNIQUE (id),
        CONSTRAINT FK_payroll_runs_types_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_types_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    );
CREATE INDEX IX_payroll_runs_types_created_by ON dbo.payroll_runs_types (created_by ASC);
CREATE INDEX IX_payroll_runs_types_countries ON dbo.payroll_runs_types (country_id ASC);
END
GO -- Table dbo.payroll_runs
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        payroll_runs_type_id VARCHAR(12) NOT NULL,
        prr_title VARCHAR(100) NOT NULL,
        prr_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_runs_id UNIQUE (id),
        CONSTRAINT FK_payroll_runs_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_payroll_runs_type FOREIGN KEY (payroll_runs_type_id) REFERENCES dbo.payroll_runs_types (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_created_by ON dbo.payroll_runs (created_by ASC);
CREATE INDEX IX_payroll_runs_countries ON dbo.payroll_runs (country_id ASC);
CREATE INDEX IX_payroll_runs_payroll_runs_type ON dbo.payroll_runs (payroll_runs_type_id ASC);
END
GO -- Table dbo.payroll_runs_benefits
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs_benefits'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs_benefits (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        payroll_runs_id VARCHAR(12) NOT NULL,
        payroll_benefits_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_runs_benefits_id UNIQUE (id),
        CONSTRAINT FK_payroll_runs_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_benefits_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_benefits_payroll_runs FOREIGN KEY (payroll_runs_id) REFERENCES dbo.payroll_runs (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_benefits_payroll_benefits FOREIGN KEY (payroll_benefits_id) REFERENCES dbo.payroll_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_benefits_created_by ON dbo.payroll_runs_benefits (created_by ASC);
CREATE INDEX IX_payroll_runs_benefits_countries ON dbo.payroll_runs_benefits (country_id ASC);
CREATE INDEX IX_payroll_runs_benefits_calcs ON dbo.payroll_runs_benefits (payroll_runs_id ASC);
CREATE INDEX IX_payroll_runs_benefits_benefits ON dbo.payroll_runs_benefits (payroll_benefits_id ASC);
END
GO -- Table dbo.payroll_runs_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs_deductions (
        id VARCHAR(12) NOT NULL,
        country_id VARCHAR(8) NOT NULL,
        payroll_runs_id VARCHAR(12) NOT NULL,
        payroll_deductions_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_deductions PRIMARY KEY (id),
        CONSTRAINT FK_payroll_runs_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_deductions_countries FOREIGN KEY (country_id) REFERENCES dbo.countries (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_deductions_payroll_deductions FOREIGN KEY (payroll_deductions_id) REFERENCES dbo.payroll_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_deductions_payroll_runs FOREIGN KEY (payroll_runs_id) REFERENCES dbo.payroll_runs (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_deductions_created_by ON dbo.payroll_runs_deductions (created_by ASC);
CREATE INDEX IX_payroll_runs_deductions_countries ON dbo.payroll_runs_deductions (country_id ASC);
CREATE INDEX IX_payroll_runs_deductions_deductions ON dbo.payroll_runs_deductions (payroll_deductions_id ASC);
CREATE INDEX IX_payroll_runs_deductions_payroll_runs ON dbo.payroll_runs_deductions (payroll_runs_id ASC);
END
GO