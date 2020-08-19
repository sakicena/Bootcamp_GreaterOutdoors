import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoAdminComponent } from './go-admin.component';

describe('GoAdminComponent', () => {
  let component: GoAdminComponent;
  let fixture: ComponentFixture<GoAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
