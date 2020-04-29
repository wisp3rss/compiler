	.section	__TEXT,__text,regular,pure_instructions
	.macosx_version_min 10, 15
	.globl	_main                   ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
## %bb.0:
	pushq	%rbx
	subq	$16, %rsp
	movl	$3, (%rsp)
	movl	$-1, 4(%rsp)
	movabsq	$4611911198408756429, %rax ## imm = 0x4000CCCCCCCCCCCD
	movq	%rax, 8(%rsp)
	leaq	_strp(%rip), %rbx
	movq	%rbx, %rdi
	movl	$3, %esi
	xorl	%eax, %eax
	callq	_printf
	leaq	_strs(%rip), %rdi
	movq	%rsp, %rsi
	xorl	%eax, %eax
	callq	___isoc99_scanf
	movl	(%rsp), %esi
	movq	%rbx, %rdi
	xorl	%eax, %eax
	callq	_printf
	xorl	%eax, %eax
	addq	$16, %rsp
	popq	%rbx
	retq
                                        ## -- End function
	.section	__TEXT,__const
	.globl	_strp                   ## @strp
_strp:
	.asciz	"%d\n"

	.globl	_strs                   ## @strs
_strs:
	.asciz	"%d"

.subsections_via_symbols
