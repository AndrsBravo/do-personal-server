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
);
END
GO IF NOT EXISTS (
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
GO
ALTER TABLE dbo.users
ADD CONSTRAINT FK_users_user_created_by FOREIGN KEY (us_created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
GO CREATE INDEX IX_users_created_by ON dbo.users (us_created_by ASC);
GO -- Table dbo.business
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business (
        id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business PRIMARY KEY (id),
        CONSTRAINT UQ_business_id UNIQUE (id),
        CONSTRAINT FK_business_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    );
CREATE INDEX IX_business_created_by ON dbo.business (created_by ASC);
END
GO -- Table dbo.temporal_frequencies
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'temporal_frequencies'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.temporal_frequencies (
        id VARCHAR(12) NOT NULL,
        tf_title VARCHAR(100) NOT NULL,
        tf_frequency VARCHAR(16) NOT NULL,
        tf_description VARCHAR(250) NULL,
        business_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_temporal_frequencies PRIMARY KEY (id),
        CONSTRAINT UQ_temporal_frequencies_id UNIQUE (id),
        CONSTRAINT FK_temporal_frequencies_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_temporal_frequencies_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_temporal_frequencies_created_by ON dbo.temporal_frequencies (created_by ASC);
CREATE INDEX IX_temporal_frequencies_business ON dbo.temporal_frequencies (business_id ASC);
END
GO -- Table dbo.organization_hierarchies
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'organization_hierarchies'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.organization_hierarchies (
        id VARCHAR(12) NOT NULL,
        orgh_hierarchy VARCHAR(16) NOT NULL,
        orgh_title VARCHAR(100) NOT NULL,
        orgh_description VARCHAR(250) NOT NULL,
        orgh_level TINYINT NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_organization_hierarchies PRIMARY KEY (id),
        CONSTRAINT UQ_organization_hierarchy_id UNIQUE (id),
        CONSTRAINT FK_hierarchy_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_organization_hierarchies_created_by ON dbo.organization_hierarchies (created_by ASC);
END
GO -- Table dbo.organization_structures
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'organization_structures'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.organization_structures (
        id VARCHAR(12) NOT NULL,
        orgs_structure VARCHAR(16) NOT NULL,
        orgs_title VARCHAR(100) NOT NULL,
        orgs_charge VARCHAR(120) NOT NULL,
        orgs_description VARCHAR(250) NULL,
        orgs_level TINYINT NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_organization_structures PRIMARY KEY (id),
        CONSTRAINT UQ_organization_structures_id UNIQUE (id),
        CONSTRAINT FK_organization_structures_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    );
CREATE INDEX IX_organization_structures_created_by ON dbo.organization_structures (created_by ASC);
END
GO -- Table dbo.organization_relations
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'organization_relations'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.organization_relations (
        id VARCHAR(12) NOT NULL,
        organization_structure VARCHAR(12) NOT NULL,
        organization_hierarchy VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_organization_relations PRIMARY KEY (id),
        CONSTRAINT UQ_organization_relations UNIQUE (id),
        CONSTRAINT FK_organization_relations_organization_structure FOREIGN KEY (organization_structure) REFERENCES dbo.organization_structures (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_relations_organization_hierarchy FOREIGN KEY (organization_hierarchy) REFERENCES dbo.organization_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_organization_relations_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_organization_relations_created_by ON dbo.organization_relations (created_by ASC);
CREATE INDEX IX_organization_relations_organization_structure ON dbo.organization_relations (organization_structure ASC);
CREATE INDEX IX_organization_relations_organization_hierarchy ON dbo.organization_relations (organization_hierarchy ASC);
END
GO -- Table dbo.business_structures
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_structures'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_structures (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        bss_structure VARCHAR(16) NOT NULL,
        bss_title VARCHAR(100) NOT NULL,
        bss_description VARCHAR(150) NULL,
        organization_structure_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_structures PRIMARY KEY (id),
        CONSTRAINT UQ_business_structures_id UNIQUE (id),
        CONSTRAINT FK_business_structures_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_structures_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_structures_organization_structures FOREIGN KEY (organization_structure_id) REFERENCES dbo.organization_structures (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_structures_created_by ON dbo.business_structures (created_by ASC);
CREATE INDEX IX_business_structures_business ON dbo.business_structures (business_id ASC);
CREATE INDEX IX_business_structures_organization_structure_id ON dbo.business_structures (organization_structure_id ASC);
END
GO -- Table dbo.business_hierarchies
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_hierarchies'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_hierarchies (
        id VARCHAR(12) NOT NULL,
        bssh_hierarchy VARCHAR(16) NOT NULL,
        bssh_title VARCHAR(100) NOT NULL,
        bssh_description VARCHAR(150) NULL,
        business_id VARCHAR(12) NOT NULL,
        organization_hierarchy_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_hierarchies PRIMARY KEY (id),
        CONSTRAINT UQ_business_hierarchies_id UNIQUE (id),
        CONSTRAINT FK_business_hierarchies_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_hierarchies_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_hierarchies_organization_hierarchy_id FOREIGN KEY (organization_hierarchy_id) REFERENCES dbo.organization_relations (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_hierarchies_created_by ON dbo.business_hierarchies (created_by ASC);
CREATE INDEX IX_business_hierarchies_business ON dbo.business_hierarchies (business_id ASC);
CREATE INDEX IX_business_hierarchies_organization_hierarchy_id ON dbo.business_hierarchies (organization_hierarchy_id ASC);
END
GO -- Table dbo.finance_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'finance_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.finance_categories (
        id VARCHAR(12) NOT NULL,
        fc_benefit_or_deduction CHAR(1) NOT NULL,
        fc_category VARCHAR(16) NOT NULL,
        fc_title VARCHAR(100) NOT NULL,
        fc_description VARCHAR(200) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_finance_categories PRIMARY KEY (id),
        CONSTRAINT UQ_finance_categories_id UNIQUE (id),
        CONSTRAINT FK_finance_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_finance_categories_created_by ON dbo.finance_categories (created_by ASC);
END
GO -- Table dbo.origin_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'origin_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.origin_categories (
        id VARCHAR(12) NOT NULL,
        oc_origin VARCHAR(16) NOT NULL,
        oc_title VARCHAR(100) NOT NULL,
        oc_description VARCHAR(200) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_origin_categories PRIMARY KEY (id),
        CONSTRAINT UQ_origin_categories_id UNIQUE (id),
        CONSTRAINT FK_origin_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_origin_categories_created_by ON dbo.origin_categories (created_by ASC);
END
GO -- Table dbo.benefit_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'benefit_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.benefit_categories (
        id VARCHAR(12) NOT NULL,
        bc_title VARCHAR(150) NOT NULL,
        bc_description VARCHAR(250) NULL,
        bc_finance_type_id VARCHAR(12) NOT NULL,
        bc_origin_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_benefit_categories PRIMARY KEY (id),
        CONSTRAINT UQ_benefit_categories_id UNIQUE (id),
        CONSTRAINT FK_benefit_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefit_categories_finance_type FOREIGN KEY (bc_finance_type_id) REFERENCES dbo.finance_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefit_categories_origin FOREIGN KEY (bc_origin_id) REFERENCES dbo.origin_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_benefit_categories_created_by ON dbo.benefit_categories (created_by ASC);
CREATE INDEX IX_benefit_categories_finance ON dbo.benefit_categories (bc_finance_type_id ASC);
CREATE INDEX IX_benefit_categories_origin ON dbo.benefit_categories (bc_origin_id ASC);
END
GO -- Table dbo.deductions_categories
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'deductions_categories'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.deductions_categories (
        id VARCHAR(12) NOT NULL,
        dc_title VARCHAR(150) NOT NULL,
        dc_description VARCHAR(250) NULL,
        dc_finance_type_id VARCHAR(12) NOT NULL,
        dc_origin_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_deductions_categories PRIMARY KEY (id),
        CONSTRAINT UQ_deductions_categories_id UNIQUE (id),
        CONSTRAINT FK_deductions_categories_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_deductions_categories_finance_type FOREIGN KEY (dc_finance_type_id) REFERENCES dbo.finance_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_deductions_categories_origin FOREIGN KEY (dc_origin_id) REFERENCES dbo.origin_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_deductions_categories_created_by ON dbo.deductions_categories (created_by ASC);
CREATE INDEX IX_deductions_categories_finance ON dbo.deductions_categories (dc_finance_type_id ASC);
CREATE INDEX IX_deductions_categories_origin ON dbo.deductions_categories (dc_origin_id ASC);
END
GO -- Table dbo.business_benefits
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_benefits'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_benefits (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        benefit_categories_id VARCHAR(12) NOT NULL,
        bb_benefit VARCHAR(16) NOT NULL,
        bb_title VARCHAR(150) NOT NULL,
        bb_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_business_benefits_id UNIQUE (id),
        CONSTRAINT FK_business_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_categories FOREIGN KEY (benefit_categories_id) REFERENCES dbo.benefit_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_benefits_created_by ON dbo.business_benefits (created_by ASC);
CREATE INDEX IX_business_benefits_business ON dbo.business_benefits (business_id ASC);
CREATE INDEX IX_business_benefits_categories ON dbo.business_benefits (benefit_categories_id ASC);
END
GO -- Table dbo.business_benefits_rates
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_benefits_rates'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_benefits_rates (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_benefit_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
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
        CONSTRAINT FK_business_benefits_rates_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_rates_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_benefits_rates_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_benefits_rates_created_by ON dbo.business_benefits_rates (created_by ASC);
CREATE INDEX IX_business_benefits_rates_business ON dbo.business_benefits_rates (business_id ASC);
CREATE INDEX IX_business_benefits_rates_benefits ON dbo.business_benefits_rates (business_benefit_id ASC);
CREATE INDEX IX_business_benefits_rates_temporal_frequency ON dbo.business_benefits_rates (temporal_frequency_id ASC);
END
GO -- Table dbo.business_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_deductions (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        bd_deduction VARCHAR(16) NOT NULL,
        bd_title VARCHAR(100) NOT NULL,
        bd_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        finance_categories_id VARCHAR(12) NOT NULL,
        origin_categories_id VARCHAR(12) NOT NULL,
        CONSTRAINT PK_business_deductions PRIMARY KEY (id),
        CONSTRAINT UQ_business_deductions_id UNIQUE (id),
        CONSTRAINT FK_business_deductions_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_finance_type FOREIGN KEY (finance_categories_id) REFERENCES dbo.finance_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_origin FOREIGN KEY (origin_categories_id) REFERENCES dbo.origin_categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_deductions_created_by ON dbo.business_deductions (created_by ASC);
CREATE INDEX IX_business_deductions_business ON dbo.business_deductions (business_id ASC);
CREATE INDEX IX_business_deductions_finance ON dbo.business_deductions (finance_categories_id ASC);
CREATE INDEX IX_business_deductions_origin ON dbo.business_deductions (origin_categories_id ASC);
END
GO -- Table dbo.business_deductions_rates
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'business_deductions_rates'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.business_deductions_rates (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_deduction_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
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
        CONSTRAINT FK_business_deductions_rates_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_rates_deductions FOREIGN KEY (business_deduction_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_business_deductions_rates_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_business_deductions_rates_created_by ON dbo.business_deductions_rates (created_by ASC);
CREATE INDEX IX_business_deductions_rates_business ON dbo.business_deductions_rates (business_id ASC);
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
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_benefit_id VARCHAR(12) NOT NULL,
        business_deduction_id VARCHAR(12) NOT NULL,
        bdb_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        bdb_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_benefits_deductions_base PRIMARY KEY (id),
        CONSTRAINT UQ_benefits_deductions_base_id UNIQUE (id),
        CONSTRAINT FK_benefits_deductions_base_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefits_deductions_base_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefits_deductions_base_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_benefits_deductions_base_deductions FOREIGN KEY (business_deduction_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_benefits_deductions_base_created_by ON dbo.benefits_deductions_base (created_by ASC);
CREATE INDEX IX_benefits_deductions_base_business ON dbo.benefits_deductions_base (business_id ASC);
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
        business_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payrolls PRIMARY KEY (id),
        CONSTRAINT UQ_payrolls_id UNIQUE (id),
        CONSTRAINT FK_payrolls_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payrolls_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payrolls_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payrolls_created_by ON dbo.payrolls (created_by ASC);
CREATE INDEX IX_payrolls_business ON dbo.payrolls (business_id ASC);
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
        business_id VARCHAR(12) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        business_benefits_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_benefits_id UNIQUE (id),
        CONSTRAINT FK_payroll_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_benefits_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_benefits_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_benefits_benefits FOREIGN KEY (business_benefits_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_benefits_created_by ON dbo.payroll_benefits (created_by ASC);
CREATE INDEX IX_payroll_benefits_business ON dbo.payroll_benefits (business_id ASC);
CREATE INDEX IX_payroll_benefits_payrolls ON dbo.payroll_benefits (payrolls_id ASC);
CREATE INDEX IX_payroll_benefits_benefits ON dbo.payroll_benefits (business_benefits_id ASC);
END
GO -- Table dbo.payroll_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_deductions (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        business_deductions_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_deductions PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_deductions_id UNIQUE (id),
        CONSTRAINT FK_payroll_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_deductions_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_deductions_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_deductions_deductions FOREIGN KEY (business_deductions_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_deductions_created_by ON dbo.payroll_deductions (created_by ASC);
CREATE INDEX IX_payroll_deductions_business ON dbo.payroll_deductions (business_id ASC);
CREATE INDEX IX_payroll_deductions_payrolls ON dbo.payroll_deductions (payrolls_id ASC);
CREATE INDEX IX_payroll_deductions_deductions ON dbo.payroll_deductions (business_deductions_id ASC);
END
GO -- Table dbo.payroll_calculations
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_calculations'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_calculations (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        prc_title VARCHAR(100) NOT NULL,
        prc_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_calculations PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_calculations_id UNIQUE (id),
        CONSTRAINT FK_payroll_calculations_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_calculations_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_calculations_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_calculations_created_by ON dbo.payroll_calculations (created_by ASC);
CREATE INDEX IX_payroll_calculations_business ON dbo.payroll_calculations (business_id ASC);
CREATE INDEX IX_payroll_calculations_payrolls ON dbo.payroll_calculations (payrolls_id ASC);
END
GO -- Table dbo.payroll_calculations_results
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_calculations_results'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_calculations_results (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        ref_id VARCHAR(12) NOT NULL,
        ref_title VARCHAR(100) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        prcr_title VARCHAR(100) NOT NULL,
        prcr_quantity MONEY NOT NULL,
        prcr_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_calculations_results PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_calculations_results_id UNIQUE (id),
        CONSTRAINT FK_payroll_calculations_results_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_calculations_results_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_calculations_results_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_calculations_results_created_by ON dbo.payroll_calculations_results (created_by ASC);
CREATE INDEX IX_payroll_calculations_results_business ON dbo.payroll_calculations_results (business_id ASC);
CREATE INDEX IX_payroll_calculations_results_payrolls ON dbo.payroll_calculations_results (payrolls_id ASC);
CREATE INDEX IX_payroll_calculations_results_ref ON dbo.payroll_calculations_results (ref_id ASC);
END
GO -- Table dbo.payroll_runs_types
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs_types'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs_types (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        prt_type VARCHAR(16) NOT NULL,
        prt_title VARCHAR(100) NOT NULL,
        prt_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_types PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_runs_types_id UNIQUE (id),
        CONSTRAINT FK_payroll_runs_types_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_types_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    );
CREATE INDEX IX_payroll_runs_types_created_by ON dbo.payroll_runs_types (created_by ASC);
CREATE INDEX IX_payroll_runs_types_business ON dbo.payroll_runs_types (business_id ASC);
END
GO -- Table dbo.payroll_runs
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
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
        CONSTRAINT FK_payroll_runs_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_payroll_runs_type FOREIGN KEY (payroll_runs_type_id) REFERENCES dbo.payroll_runs_types (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_created_by ON dbo.payroll_runs (created_by ASC);
CREATE INDEX IX_payroll_runs_business ON dbo.payroll_runs (business_id ASC);
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
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        payroll_runs_id VARCHAR(12) NOT NULL,
        payroll_benefits_id VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_runs_benefits_id UNIQUE (id),
        CONSTRAINT FK_payroll_runs_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_benefits_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_benefits_payroll_runs FOREIGN KEY (payroll_runs_id) REFERENCES dbo.payroll_runs (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_benefits_payroll_benefits FOREIGN KEY (payroll_benefits_id) REFERENCES dbo.payroll_benefits (business_benefits_id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_benefits_created_by ON dbo.payroll_runs_benefits (created_by ASC);
CREATE INDEX IX_payroll_runs_benefits_business ON dbo.payroll_runs_benefits (business_id ASC);
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
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        payroll_deductions_id VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_deductions PRIMARY KEY (id),
        CONSTRAINT FK_payroll_runs_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_deductions_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_deductions_payroll_deductions FOREIGN KEY (payroll_deductions_id) REFERENCES dbo.payroll_deductions (business_deductions_id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_deductions_created_by ON dbo.payroll_runs_deductions (created_by ASC);
CREATE INDEX IX_payroll_runs_deductions_business ON dbo.payroll_runs_deductions (business_id ASC);
CREATE INDEX IX_payroll_runs_deductions_deductions ON dbo.payroll_runs_deductions (payroll_deductions_id ASC);
END
GO -- Table dbo.payroll_runs_results
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_runs_results'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_runs_results (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        ref_id VARCHAR(12) NOT NULL,
        ref_title VARCHAR(100) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        prrr_title VARCHAR(100) NOT NULL,
        prrr_quantity MONEY NOT NULL,
        prrr_description VARCHAR(250) NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_runs_results PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_runs_results_id UNIQUE (id),
        CONSTRAINT FK_payroll_runs_results_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_results_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_runs_results_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_runs_results_created_by ON dbo.payroll_runs_results (created_by ASC);
CREATE INDEX IX_payroll_runs_results_business ON dbo.payroll_runs_results (business_id ASC);
CREATE INDEX IX_payroll_runs_results_payrolls ON dbo.payroll_runs_results (payrolls_id ASC);
CREATE INDEX IX_payroll_runs_results_ref ON dbo.payroll_runs_results (ref_id ASC);
END
GO -- Table dbo.hierarchies_benefits
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'hierarchies_benefits'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.hierarchies_benefits (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_hierarchy_id VARCHAR(12) NOT NULL,
        business_benefits_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_hierarchies_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_hierarchies_benefits_id UNIQUE (id),
        CONSTRAINT FK_hierarchies_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_hierarchy FOREIGN KEY (business_hierarchy_id) REFERENCES dbo.business_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_benefits FOREIGN KEY (business_benefits_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_hierarchies_benefits_created_by ON dbo.hierarchies_benefits (created_by ASC);
CREATE INDEX IX_hierarchies_benefits_business ON dbo.hierarchies_benefits (business_id ASC);
CREATE INDEX IX_hierarchies_benefits_hierarchy ON dbo.hierarchies_benefits (business_hierarchy_id ASC);
CREATE INDEX IX_hierarchies_benefits_benefits ON dbo.hierarchies_benefits (business_benefits_id ASC);
END
GO -- Table dbo.hierarchies_benefits_feeds
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'hierarchies_benefits_feeds'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.hierarchies_benefits_feeds (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_benefits_id VARCHAR(12) NOT NULL,
        business_hierarchy_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
        hbf_amount MONEY NOT NULL,
        hbf_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        hbf_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_hierarchies_benefits_feeds PRIMARY KEY (id),
        CONSTRAINT UQ_hierarchies_benefits_feeds_id UNIQUE (id),
        CONSTRAINT FK_hierarchies_benefits_feeds_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_feeds_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_feeds_hierarchy FOREIGN KEY (business_hierarchy_id) REFERENCES dbo.business_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_feeds_benefits FOREIGN KEY (business_benefits_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_benefits_feeds_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_hierarchies_benefits_feeds_created_by ON dbo.hierarchies_benefits_feeds (created_by ASC);
CREATE INDEX IX_hierarchies_benefits_feeds_business ON dbo.hierarchies_benefits_feeds (business_id ASC);
CREATE INDEX IX_hierarchies_benefits_feeds_hierarchy ON dbo.hierarchies_benefits_feeds (business_hierarchy_id ASC);
CREATE INDEX IX_hierarchies_benefits_feeds_benefits ON dbo.hierarchies_benefits_feeds (business_benefits_id ASC);
CREATE INDEX IX_hierarchies_benefits_feeds_temporal_frequency ON dbo.hierarchies_benefits_feeds (temporal_frequency_id ASC);
END
GO -- Table dbo.hierarchies_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'hierarchies_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.hierarchies_deductions (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_hierarchy_id VARCHAR(12) NOT NULL,
        business_deductions_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_hierarchies_deductions PRIMARY KEY (id),
        CONSTRAINT UQ_hierarchies_deductions_id UNIQUE (id),
        CONSTRAINT FK_hierarchies_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_hierarchy FOREIGN KEY (business_hierarchy_id) REFERENCES dbo.business_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_deductions FOREIGN KEY (business_deductions_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_hierarchies_deductions_created_by ON dbo.hierarchies_deductions (created_by ASC);
CREATE INDEX IX_hierarchies_deductions_business ON dbo.hierarchies_deductions (business_id ASC);
CREATE INDEX IX_hierarchies_deductions_deductions ON dbo.hierarchies_deductions (business_deductions_id ASC);
CREATE INDEX IX_hierarchies_deductions_hierarchy ON dbo.hierarchies_deductions (business_hierarchy_id ASC);
END
GO -- Table dbo.hierarchies_deductions_feeds
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'hierarchies_deductions_feeds'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.hierarchies_deductions_feeds (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_deductions_id VARCHAR(12) NOT NULL,
        business_hierarchy_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
        hdf_amount MONEY NOT NULL,
        hdf_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        hdf_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_hierarchies_deductions_feeds PRIMARY KEY (id),
        CONSTRAINT UQ_hierarchies_deductions_feeds_id UNIQUE (id),
        CONSTRAINT FK_hierarchies_deductions_feeds_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_feeds_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_feeds_hierarchy FOREIGN KEY (business_hierarchy_id) REFERENCES dbo.business_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_feeds_deductions FOREIGN KEY (business_deductions_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_hierarchies_deductions_feeds_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_hierarchies_deductions_feeds_created_by ON dbo.hierarchies_deductions_feeds (created_by ASC);
CREATE INDEX IX_hierarchies_deductions_feeds_business ON dbo.hierarchies_deductions_feeds (business_id ASC);
CREATE INDEX IX_hierarchies_deductions_feeds_hierarchy ON dbo.hierarchies_deductions_feeds (business_hierarchy_id ASC);
CREATE INDEX IX_hierarchies_deductions_feeds_deductions ON dbo.hierarchies_deductions_feeds (business_deductions_id ASC);
CREATE INDEX IX_hierarchies_deductions_feeds_temporal_frequency ON dbo.hierarchies_deductions_feeds (temporal_frequency_id ASC);
END
GO -- Table dbo.employees
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'employees'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.employees (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        e_name VARCHAR(100) NOT NULL,
        e_last_name VARCHAR(100) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_employees PRIMARY KEY (id),
        CONSTRAINT UQ_employees_id UNIQUE (id),
        CONSTRAINT FK_employees_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employees_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_employees_created_by ON dbo.employees (created_by ASC);
CREATE INDEX IX_employees_business ON dbo.employees (business_id ASC);
END
GO -- Table dbo.payroll_employee
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'payroll_employee'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.payroll_employee (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        payrolls_id VARCHAR(12) NOT NULL,
        employees_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_payroll_employee PRIMARY KEY (id),
        CONSTRAINT UQ_payroll_employee_id UNIQUE (id),
        CONSTRAINT FK_payroll_employee_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_employee_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_employee_payrolls FOREIGN KEY (payrolls_id) REFERENCES dbo.payrolls (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_payroll_employee_employees FOREIGN KEY (employees_id) REFERENCES dbo.employees (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_payroll_employee_created_by ON dbo.payroll_employee (created_by ASC);
CREATE INDEX IX_payroll_employee_business ON dbo.payroll_employee (business_id ASC);
CREATE INDEX IX_payroll_employee_payrolls ON dbo.payroll_employee (payrolls_id ASC);
CREATE INDEX IX_payroll_employee_employees ON dbo.payroll_employee (employees_id ASC);
END
GO -- Table dbo.employee_scale
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'employee_scale'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.employee_scale (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        employees_id VARCHAR(12) NOT NULL,
        business_hierarchy_id VARCHAR(12) NOT NULL,
        es_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        es_ended_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_employee_scale PRIMARY KEY (id),
        CONSTRAINT UQ_employee_scale_id UNIQUE (id),
        CONSTRAINT FK_employee_scale_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_scale_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_scale_employees FOREIGN KEY (employees_id) REFERENCES dbo.employees (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_scale_hierarchy FOREIGN KEY (business_hierarchy_id) REFERENCES dbo.business_hierarchies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_employee_scale_created_by ON dbo.employee_scale (created_by ASC);
CREATE INDEX IX_employee_scale_business ON dbo.employee_scale (business_id ASC);
CREATE INDEX IX_employee_scale_employees ON dbo.employee_scale (employees_id ASC);
CREATE INDEX IX_employee_scale_hierarchy ON dbo.employee_scale (business_hierarchy_id ASC);
END
GO -- Table dbo.employee_benefits
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'employee_benefits'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.employee_benefits (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        employees_id VARCHAR(12) NOT NULL,
        business_benefit_id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_employee_benefits PRIMARY KEY (id),
        CONSTRAINT UQ_employee_benefits_id UNIQUE (id),
        CONSTRAINT FK_employee_benefits_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_employees FOREIGN KEY (employees_id) REFERENCES dbo.employees (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_employee_benefits_created_by ON dbo.employee_benefits (created_by ASC);
CREATE INDEX IX_employee_benefits_business ON dbo.employee_benefits (business_id ASC);
CREATE INDEX IX_employee_benefits_benefits ON dbo.employee_benefits (business_benefit_id ASC);
CREATE INDEX IX_employee_benefits_employees ON dbo.employee_benefits (employees_id ASC);
END
GO -- Table dbo.employee_deductions
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'employee_deductions'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.employee_deductions (
        id VARCHAR(12) NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        employees_id VARCHAR(12) NOT NULL,
        business_deductions_id VARCHAR(12) NOT NULL,
        CONSTRAINT PK_employee_deductions PRIMARY KEY (id),
        CONSTRAINT UQ_employee_deductions_id UNIQUE (id),
        CONSTRAINT FK_employee_deductions_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_employees FOREIGN KEY (employees_id) REFERENCES dbo.employees (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_deductions FOREIGN KEY (business_deductions_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_employee_deductions_created_by ON dbo.employee_deductions (created_by ASC);
CREATE INDEX IX_employee_deductions_business ON dbo.employee_deductions (business_id ASC);
CREATE INDEX IX_employee_deductions_employees ON dbo.employee_deductions (employees_id ASC);
CREATE INDEX IX_employee_deductions_deductions ON dbo.employee_deductions (business_deductions_id ASC);
END
GO -- Table dbo.employee_benefits_feeds
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'employee_benefits_feeds'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.employee_benefits_feeds (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_benefit_id VARCHAR(12) NOT NULL,
        employee_id VARCHAR(12) NOT NULL,
        employee_benefit_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
        ebf_amount MONEY NOT NULL,
        ebf_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        ebf_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_employee_benefits_feeds PRIMARY KEY (id),
        CONSTRAINT UQ_employee_benefits_feeds_id UNIQUE (id),
        CONSTRAINT FK_employee_benefits_feeds_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_feeds_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_feeds_benefits FOREIGN KEY (employee_id) REFERENCES dbo.employees (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_feeds_benefits FOREIGN KEY (employee_benefit_id) REFERENCES dbo.employee_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_feeds_benefits FOREIGN KEY (business_benefit_id) REFERENCES dbo.business_benefits (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_benefits_feeds_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_employee_benefits_feeds_created_by ON dbo.employee_benefits_feeds (created_by ASC);
CREATE INDEX IX_employee_benefits_feeds_business ON dbo.employee_benefits_feeds (business_id ASC);
CREATE INDEX IX_employee_benefits_feeds_employee ON dbo.employees (employee_id ASC);
CREATE INDEX IX_employee_benefits_feeds_benefits ON dbo.employee_benefits_feeds (employee_benefit_id ASC);
CREATE INDEX IX_employee_benefits_feeds_business_benefits ON dbo.employee_benefits_feeds (business_benefit_id ASC);
CREATE INDEX IX_employee_benefits_feeds_temporal_frequency ON dbo.employee_benefits_feeds (temporal_frequency_id ASC);
END
GO -- Table dbo.employee_deductions_feeds
    IF NOT EXISTS (
        SELECT *
        FROM sys.tables
        WHERE name = 'employee_deductions_feeds'
            AND schema_id = SCHEMA_ID('dbo')
    ) BEGIN CREATE TABLE dbo.employee_deductions_feeds (
        id VARCHAR(12) NOT NULL,
        business_id VARCHAR(12) NOT NULL,
        business_deduction_id VARCHAR(12) NOT NULL,
        employee_deduction_id VARCHAR(12) NOT NULL,
        temporal_frequency_id VARCHAR(12) NOT NULL,
        edf_amount MONEY NOT NULL,
        edf_started_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        edf_ended_at DATETIME2 NOT NULL,
        created_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        updated_at DATETIME2 NOT NULL DEFAULT SYSDATETIME(),
        created_by VARCHAR(12) NOT NULL,
        CONSTRAINT PK_employee_deductions_feeds PRIMARY KEY (id),
        CONSTRAINT UQ_employee_deductions_feeds_id UNIQUE (id),
        CONSTRAINT FK_employee_deductions_feeds_created_by FOREIGN KEY (created_by) REFERENCES dbo.users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_feeds_business FOREIGN KEY (business_id) REFERENCES dbo.business (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_feeds_employee_deduction_id FOREIGN KEY (employee_deduction_id) REFERENCES dbo.employee_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_feeds_deductions FOREIGN KEY (business_deduction_id) REFERENCES dbo.business_deductions (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
        CONSTRAINT FK_employee_deductions_feeds_temporal_frequency FOREIGN KEY (temporal_frequency_id) REFERENCES dbo.temporal_frequencies (id) ON DELETE NO ACTION ON UPDATE NO ACTION
    );
CREATE INDEX IX_employee_deductions_feeds_created_by ON dbo.employee_deductions_feeds (created_by ASC);
CREATE INDEX IX_employee_deductions_feeds_business ON dbo.employee_deductions_feeds (business_id ASC);
CREATE INDEX IX_employee_deductions_feeds_employee_deduction_id ON dbo.employee_deductions_feeds (employee_deduction_id ASC);
CREATE INDEX IX_employee_deductions_feeds_deductions ON dbo.employee_deductions_feeds (business_deduction_id ASC);
CREATE INDEX IX_employee_deductions_feeds_temporal_frequency ON dbo.employee_deductions_feeds (temporal_frequency_id ASC);
END
GO