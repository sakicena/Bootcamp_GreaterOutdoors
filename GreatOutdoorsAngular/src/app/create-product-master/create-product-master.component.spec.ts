import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateProductMasterComponent } from './create-product-master.component';

describe('CreateProductMasterComponent', () => {
  let component: CreateProductMasterComponent;
  let fixture: ComponentFixture<CreateProductMasterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateProductMasterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateProductMasterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
