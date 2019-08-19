package com.lms.utils;

public class View {
	public interface HideProperties {
	}

	public interface University {
	}

	public interface UniversityWithFaculties extends University {
	}

	public interface Faculty {
	};

	public interface YearOfStudy {
	};

	public interface StudyProgramme {
	};

	public interface StudyProgrammeWithYearsOfStudyWithSubjects extends YearOfStudy, StudyProgramme {
	};

	public interface Subject {
	};

//=========================
//					@JsonView with multiple identifiers
//=========================
//	As explained in Jackson JsonView documentation, "only single active view per serialization; but due to inheritance of Views, can combine Views via aggregation".
//
//	Concretely, if you want to use both Foo and Bar JsonViews, define a FooBar interface that combine them as following:
//
//	interface Foo {}
//
//	interface Bar {}
//
//	interface FooBar extends Foo, Bar {}
//	You can then annotate your fields with @JsonView(Foo.class) or @JsonView(Bar.class) and use @JsonView(FooBar.class) at controller level.
}
